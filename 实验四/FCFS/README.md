
# ʵ���ġ���ģ��ʵ��FCFS(�����ȷ���)
## ʵ������
* FCFS�㷨�������񵽴��˳����з��������ȷ���
* ����(Task)��ID����ʼʱ��ͷ���ʱ����input.txt�ļ�����,��������б��ļ������ɳ������ɣ�ÿ��һ������ﵽ������ʱ����{6,2,1,3,9}��������е����������ȡ���ļ��б�Ҫ��������100������
* ��Ҫ��ʵ������Ҫ���FCFS
* ��ֻ��һ���������ʱ�����
* ���������������ʱ�����

* Task������������ԣ�
* taskID //����ID
* arrivalTime //����ʱ��
* serviceTime //����ʱ��
* startingTime //��ʼʱ��
* finishingTime //���ʱ��=��ʼʱ��+����ʱ��
* turnAroundTime //��תʱ��=���ʱ��-�ﵽʱ��
* weightTurnAround //��Ȩ��תʱ��=��תʱ��/����ʱ��

* ʵ����������input.txt��

## �������
Task�Ĺ�������resolve����������input.txt�ļ���ȡ��int���������ڷ����ڼ��㱣�棬����ӡ����
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
��ȡͬʱ����������������Max_Task��
```javascript
System.out.println("choose your Task_num");
    	Scanner scanner=new Scanner(System.in);
		Max_Task=scanner.nextInt();
		scanner.close();
```
��������ʼ��[]Task��������У���������
```javascript
if(Max_Task<=0)
    		return;
		Task []task=new Task[Max_Task];
		for(i=0;i<Max_Task;i++)
			task[i]=new Task();
```
ÿ�δ�input��ȡ������������flag������������Ƿ��Ѿ��ַ�����Task���ڿն���ʱ����finishingTime=0�жϣ���˳���������
```javascript
while(input.hasNextInt()){
    		 ID=input.nextInt();
			 arrivalTime=input.nextInt();
			 serviceTime=input.nextInt();
			 int fast=0;//���ȴ�����Ķ���
			 boolean flag=true;
		for(i=0;i<Max_Task;i++){

			if(task[i].finishingTime==0){
				task[i].resolve(ID, arrivalTime, serviceTime);
				flag=false;
				break;
			}
```
��ÿ��������ж���ʱ���ҳ������ɵ�task��ű�����fast��,��������
```javascript
if(flag!=false){
    		if(Max_Task==1)
				task[0].resolve(ID, arrivalTime, serviceTime);
			else{//�ҳ�finishTime��С���Ǹ�
				for(i=0;i<Max_Task-1;i++){
					if(task[i+1].finishingTime<task[fast].finishingTime)
						fast=i+1;
				}
				task[fast].resolve(ID, arrivalTime, serviceTime);
			}
}
```
* ȫ�Ľ�������л�Ķ������в��ף���ӭָ��~

## ��������
* ��һ������
* �ʼ�(13799671597@163.com)
* weibo: [@���QML](http://weibo.com/ihubo)