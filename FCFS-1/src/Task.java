import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Task {
	int taskID;
	int arrivalTime;
	int serviceTime;
	int startingTime;
	int finishingTime;
	int turnAroundTime;
	int weightTurnAround;
	public boolean MakeTask(){
		try{
			  int []r={6,2,1,3,9} ;
			  String data="";
			  for(int i=1;i<101;i++){
				  int x=(int)(Math.random()*10)%5;	
				  data +=i+" "+(i-1)+" "+r[x]+"\r\n";
			  }
		      

		      File file =new File("test.txt");

		      //if file doesnt exists, then create it
		      if(!file.exists()){
		       file.createNewFile();
		      }

		      //true = append file
		      FileWriter fileWritter = new FileWriter(file.getName(),true);
		             BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
		             bufferWritter.write(data);
		             bufferWritter.close();

		       return true;

		     }catch(IOException e){
		      e.printStackTrace();
		     }
		return false;
	}
	public Task(int taskID, int arrivalTime, int serviceTime) {
        this.taskID = taskID;
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
    }
	public Task() {
		// TODO �Զ����ɵĹ��캯�����
	}
	public int getProcessID() {
        return taskID;
    }
	 public void setProcessID(int processID) {
	        this.taskID = processID;
	    }

	    public int getArrivalTime() {
	        return arrivalTime;
	    }
	    public void setArrivalTime(int arrivalTime) {
	        this.arrivalTime = arrivalTime;
	    }
	    public int getServiceTime() {
	        return serviceTime;
	    }
	    public void setServiceTime(int serviceTime) {
	        this.serviceTime = serviceTime;
	    }
	    public int getStartingTime() {
	        return startingTime;
	    }
	    public void setStartingTime(int startingTime) {
	        this.startingTime = startingTime;
	    }
	    public int getFinishingTime() {
	        return finishingTime;
	    }
	    public void setFinishingTime(int finishingTime) {
	        this.finishingTime = finishingTime;
	    }
	    public int getTurnAroundTime() {
	        return turnAroundTime;
	    }
	    public void setTurnAroundTime(int turnAroundTime) {
	        this.turnAroundTime = turnAroundTime;
	    }
	    @Override
	    public String toString() {
	        return "Process [processID=" + taskID + ", arrivalTime="
	                + arrivalTime + ", serviceTime=" + serviceTime
	                + ", startingTime=" + startingTime + ", finishingTime="
	                + finishingTime + ", turnAroundTime=" + turnAroundTime
	                + ", averageTAT=";
	    }
	

	public void Service(){
		 File file = new File("test.txt");
		  Reader reader = null;
		  Task task1=new Task();
		  try {
		   System.out.println("���ַ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���ֽڣ�");
		   // һ�ζ�һ���ַ�
		   reader = new InputStreamReader(new FileInputStream(file));
		   int tempchar;
		   while ((tempchar = reader.read()) != -1) {
		    // ����windows�£�\r\n�������ַ���һ��ʱ����ʾһ�����С�
		    // ������������ַ��ֿ���ʾʱ���ỻ�����С�
		    // ��ˣ����ε�\r����������\n�����򣬽������ܶ���С�
		    if (((char) tempchar) != '\r') {
		    task1.taskID=tempchar;		    
		    tempchar = reader.read();tempchar = reader.read();
		    task1.arrivalTime=tempchar;
		    tempchar = reader.read();tempchar = reader.read();
		    task1.serviceTime=tempchar;
		    System.out.println("����"+task1.taskID+"�Ѿ���ɣ�����ʱ��Ϊ"+task1.serviceTime);
		    }
		   }
		   reader.close();
		  } catch (Exception e) {
		   e.printStackTrace();
		  }

	}
}
