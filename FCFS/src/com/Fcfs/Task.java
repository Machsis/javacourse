package com.Fcfs;

import java.util.Scanner;
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
	public void resolve(int id,int arrival,int service)throws IOException{

		taskID=id;
		arrivalTime=arrival;
		serviceTime=service;
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
