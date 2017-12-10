
# 实验四——模拟实现SJF(短作业优先)
## 实验内容
* SJF算法首先调度已到达的任务中，服务时间最短的任务，这里不要求实现任务的抢占。
* 按照FCFS算法的要求实现SJF算法，同样要求处理两种情况：
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
Task的公共方法resolve接受从input.txt文件读取的Task对象，并在方法内计算保存，最后打印出来
```javascript
  public void resolve(Task task)throws IOException{

    	taskID=task.taskID;
		arrivalTime=task.arrivalTime;
		serviceTime=task.serviceTime;
		if(finishingTime>arrivalTime)
		startingTime=finishingTime;
		else
			startingTime=arrivalTime;
		finishingTime=startingTime+serviceTime;
		turnAroundTime=finishingTime-arrivalTime;
		weightTurnAround=turnAroundTime/serviceTime;
		System.out.println(taskID+"\t"+arrivalTime+"\t\t"+serviceTime+"\t\t"+
		startingTime+"\t\t"+finishingTime+"\t\t"+turnAroundTime+"\t\t"+weightTurnAround);

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
初始分派任务，这里是先一次性轮流分派最大处理队列数任务，保证队列吞吐率最大
```javascript
if (Max_Task != 1)
    		for (i = 0; i < Max_Task; i++) {
				ID = input.nextInt();
				arrivalTime = input.nextInt();
				serviceTime = input.nextInt();
				task[i].resolve(new Task(ID, arrivalTime, serviceTime));
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
总体思路是排序->分派任务->添加进等待时间内到达的队列，当线性列表taskCome中没有等待队列就结束循环
```javascript
while (!taskCome.isEmpty()) {
			boolean is_not_resolve = true;
			int fast = 0;
			Collections.sort(taskCome, new Comparator<Task>() {
				public int compare(Task o1, Task o2) {
					return o1.serviceTime - o2.serviceTime;
				}
			});
			if (is_not_resolve) {
				for (i = 0; i < Max_Task - 1; i++) {
					if (task[i + 1].finishingTime < task[fast].finishingTime)
						fast = i + 1;
				}
				task[fast].resolve(taskCome.get(0));

			}
			if (input.hasNextInt()) {
				for (i = 0; i < taskCome.get(0).serviceTime; i++) {
					try {
						ID = input.nextInt();
						arrivalTime = input.nextInt();
						serviceTime = input.nextInt();
						taskCome.add(new Task(ID, arrivalTime, serviceTime));
					}

					catch (Exception e) {
						break;
					}
				}

			}
			taskCome.remove(0);
		}
		input.close();
```
##### 总结：
* 本文没有模拟按时间读取，但显示结果应该正确无误
* 一开始多个队列同时分配任务有两种方法选择困扰了我，此处是不考虑先前任务结束，而是同时分满空队列
* 全文结束，感谢阅读，如有不妥，欢迎指出~

## 关于作者
* 软工一班李明
* 邮件(13799671597@163.com)
* weibo: [@潮鳴ML](http://weibo.com/u/5671356526)