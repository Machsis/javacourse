package com.Test1;
import java.io.*;
import java.util.Scanner;
public class Test {

	public static void main(String[] args)throws IOException {
		// TODO 自动生成的方法存根
		File sourceFile=new File("src.txt");
		File targetFile=new File("dest.txt");
		PrintWriter output=new PrintWriter(sourceFile);
		if(!sourceFile.exists()){
			sourceFile.createNewFile();
		}
		if(!targetFile.exists()){
			targetFile.createNewFile();
		}
		Scanner scanner=new Scanner(System.in);
		output.print(scanner.next());
		scanner.close();
		output.close();
		//create an input Stream
		BufferedInputStream Input=new BufferedInputStream
				(new FileInputStream(sourceFile));
		//create an output Stream
				BufferedOutputStream Output=new BufferedOutputStream
						(new FileOutputStream(targetFile));
		int r;
		while((r=Input.read())!=-1)
			Output.write((byte)r);
		Input.close();
		Output.close();
		System.out.println("Copy Done");
		Scanner dest=new Scanner(targetFile);
		System.out.println(dest.next());
		dest.close();
	}

}
