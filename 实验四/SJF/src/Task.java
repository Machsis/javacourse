
import java.io.*;
public class Task {
	int taskID=0;
	int arrivalTime=0;
	int serviceTime=0;
	int startingTime=0;
	int finishingTime=0;
	float turnAroundTime=0.0f;
	float weightTurnAround=0;
	public Task(){
		
	}
	public Task(int id,int arr,int ser){
		taskID=id;
		arrivalTime=arr;
		serviceTime=ser;
	}
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
}
