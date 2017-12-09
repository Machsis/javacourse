
# 实验四——模拟实现FCFS(先来先服务)
## 实验内容
* FCFS算法按照任务到达的顺序进行服务，先来先服务
* 任务(Task)的ID、开始时间和服务时间由input.txt文件读入,这个任务列表文件首先由程序生成，每秒一个任务达到，服务时间由{6,2,1,3,9}这个集合中的数据随机获取。文件列表要包含至少100个任务。
* 先要求实现如下要求的FCFS
* 当只有一个处理队列时的情况
* 当有两个处理队列时的情况

* Task类包含下列属性：
* taskID //任务ID
* arrivalTime //到达时间
* serviceTime //服务时间
* startingTime //开始时间
* finishingTime //完成时间=开始时间+服务时间
* turnAroundTime //周转时间=完成时间-达到时间
* weightTurnAround //带权周转时间=周转时间/服务时间

* 实验结果保存在input.txt中

## 代码分析
Task的公共方法resolve接受三个从input.txt文件读取的int参数，并在方法内计算保存，最后打印出来
```javascript
  public void resolve(int id, int arrival, int service) throws IOException {
        taskID = id;
		arrivalTime = arrival;
		serviceTime = service;
		if (finishingTime > arrivalTime)
			startingTime = finishingTime;
		else
			startingTime = arrivalTime;
		finishingTime = startingTime + serviceTime;
		turnAroundTime = finishingTime - arrivalTime;
		weightTurnAround = turnAroundTime / serviceTime;
		System.out.println(taskID + "\t" + arrivalTime + "\t\t" + serviceTime + "\t\t" + startingTime + "\t\t"
				+ finishingTime + "\t\t" + turnAroundTime + "\t\t" + weightTurnAround);
	}
```
读取同时最大处理队列数保存在Max_Task中
```javascript
System.out.println("choose your Task_num");
    	Scanner scanner=new Scanner(System.in);
		Max_Task=scanner.nextInt();
		scanner.close();
```
创建并初始化[]Task（处理队列）对象数组
```javascript
if(Max_Task<=0)
    		return;
		Task []task=new Task[Max_Task];
		for(i=0;i<Max_Task;i++)
			task[i]=new Task();
```
每次从input读取输入三个数，flag用来标记任务是否已经分发，当Task存在空队列时（用finishingTime=0判断）按顺序分派任务
```javascript
while(input.hasNextInt()){
    		 ID=input.nextInt();
			 arrivalTime=input.nextInt();
			 serviceTime=input.nextInt();
			 int fast=0;//最先处理完的队列
			 boolean flag=true;
		for(i=0;i<Max_Task;i++){

			if(task[i].finishingTime==0){
				task[i].resolve(ID, arrivalTime, serviceTime);
				flag=false;
				break;
			}
```
当每个处理队列都满时，找出最快完成的task编号保存在fast中,分派任务
```javascript
if(flag!=false){
    		if(Max_Task==1)
				task[0].resolve(ID, arrivalTime, serviceTime);
			else{//找出finishTime最小的那个
				for(i=0;i<Max_Task-1;i++){
					if(task[i+1].finishingTime<task[fast].finishingTime)
						fast=i+1;
				}
				task[fast].resolve(ID, arrivalTime, serviceTime);
			}
}
```
* 全文结束，感谢阅读，如有不妥，欢迎指出~

## 关于作者
* 软工一班李明
* 邮件(13799671597@163.com)
* weibo: [@潮鳴ML](http://weibo.com/ihubo)