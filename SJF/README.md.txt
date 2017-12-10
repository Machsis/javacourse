
# ʵ���ġ���ģ��ʵ��FCFS(�����ȷ���)
## ʵ������
* SJF�㷨���ȵ����ѵ���������У�����ʱ����̵��������ﲻҪ��ʵ���������ռ��
* ����FCFS�㷨��Ҫ��ʵ��SJF�㷨��ͬ��Ҫ�������������
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
Task�Ĺ�������resolve���ܴ�input.txt�ļ���ȡ��Task���󣬲��ڷ����ڼ��㱣�棬����ӡ����
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
��ʼ����������������һ�������������������������񣬱�֤�������������
```javascript
if (Max_Task != 1)
    		for (i = 0; i < Max_Task; i++) {
				ID = input.nextInt();
				arrivalTime = input.nextInt();
				serviceTime = input.nextInt();
				task[i].resolve(new Task(ID, arrivalTime, serviceTime));
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
����˼·������->��������->��ӽ��ȴ�ʱ���ڵ���Ķ��У��������б�taskCome��û�еȴ����оͽ���ѭ��
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
##### �ܽ᣺
* ����û��ģ�ⰴʱ���ȡ������ʾ���Ӧ����ȷ����
* һ��ʼ�������ͬʱ�������������ַ���ѡ���������ң��˴��ǲ�������ǰ�������������ͬʱ�����ն���
* ȫ�Ľ�������л�Ķ������в��ף���ӭָ��~

## ��������
* ��һ������
* �ʼ�(13799671597@163.com)
* weibo: [@���QML](http://weibo.com/u/5671356526)