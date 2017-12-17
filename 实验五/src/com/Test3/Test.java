/**
 * 
 */
package com.Test3;
import java.io.*;

/**
 * @author lm
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException {
		// TODO 自动生成的方法存根
		//开始计时
		long startMili=System.currentTimeMillis();
		System.out.println("No bufferedReader");
		System.out.println("start time:0");
		FileReader reader=new FileReader("Test3_input.txt");
		FileWriter writer=new FileWriter("Test3_output.txt");
		int EOF=-1;
		while((EOF=reader.read())!=-1){
			writer.write((char)EOF);
		}
		reader.close();
		writer.close();
		//结束计时
		long finishMili=System.currentTimeMillis();
		System.out.println("finished time:"+(finishMili-startMili));
		
		System.out.println("bufferedReader");
		//开始计时
		long startMili2=System.currentTimeMillis();
		System.out.println("No bufferedReader");
		System.out.println("start time:0");
		BufferedReader reader2=new BufferedReader(new FileReader("Test3_source.txt"));
		BufferedWriter writer2=new BufferedWriter(new FileWriter("Test3_target.txt"));
		while((EOF=reader2.read())!=-1){
			writer2.write((char)EOF);
		}
		reader2.close();
		writer2.close();
		//结束计时
		long finishMili2=System.currentTimeMillis();
		System.out.println("finished time:"+(finishMili2-startMili2));
	}

}
