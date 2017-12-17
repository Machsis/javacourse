/**
 * 
 */
package com.Test2;
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
/**
 * @author lm
 * 实验二 获取系统文件树
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException {
		// TODO 自动生成的方法存根
		System.out.print("enter the directory you want to browse\n");
		Scanner scanner=new Scanner(System.in);
		String dir=scanner.next();
		scanner.close();
		File file=new File(dir);
		if(!file.exists()){
			System.out.println("wrong directory!");
			System.exit(0);
		}
		List<File> files = Arrays.asList(file.listFiles());
		Collections.sort(files, new Comparator<File>(){
			@Override
		    public int compare(File o1, File o2) {
		    if(o1.isDirectory()&& o2.isFile())
		        return -1;
		    if(o1.isFile()&& o2.isDirectory())
		            return 1;
		    return o1.getName().compareTo(o2.getName());
		    }
		});
		PrintWriter print=new PrintWriter(new File("Test2_output.txt"));
		print.println("FileName\t\tLastModified\t\t\t\tlenth");
		//System.out.println(name.getName()+"\t\t"+new Date(name.lastModified())+"\t\t"+name.length());
		for(File name:files){
		print.println(name.getName()+"\t\t"+new Date(name.lastModified())+"\t\t"+name.length());
		//System.out.println(name.getName()+"\t\t"+new Date(name.lastModified())+"\t\t"+name.length());
		}
		print.close();
	}

}
