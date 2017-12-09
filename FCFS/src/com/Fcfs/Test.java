package com.Fcfs;

import java.io.*;
import java.util.Scanner;

public class Test {
	public static void main(String []Args)throws IOException{
		int Max_Task=0;
		int i;
		int ID,arrivalTime,serviceTime;
		System.out.println("choose your Task_num");
		Scanner scanner=new Scanner(System.in);
		Max_Task=scanner.nextInt();
		scanner.close();
		if(Max_Task<=0)
			return;
		Task []task=new Task[Max_Task];
		for(i=0;i<Max_Task;i++)
			task[i]=new Task();
		Scanner input=new Scanner(new File("input.txt"));	
		System.out.println("TaskID\tArrivalTime\tServiceTime\tStartingTime\tFinishingTime\tTurnAroundTime\tWeightTurnAround");
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
		}
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
		}
		input.close();
	}

}
