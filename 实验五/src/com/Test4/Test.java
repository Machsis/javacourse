/**
 * 
 */
package com.Test4;
import java.io.*;
import java.util.*;
/**
 * @author lm
 *
 */
public class Test {

	/**
	 * @param args
	 * throws IOException
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args)throws IOException, ClassNotFoundException {
		// TODO 自动生成的方法存根
		File file=new File("1.txt");
		Scanner scanner=new Scanner(file);
		List<Student> stuList=new ArrayList();
		while(scanner.hasNext()){
			String No=scanner.next();
			String name=scanner.next();
			String sex=scanner.next();
			stuList.add(new Student(No,name,sex));
		}
		scanner.close();
		Collections.sort(stuList,new Comparator<Student>(){
			@Override
			public int compare(Student a,Student b){
				return a.num.compareTo(b.num);

			}
		});
		ObjectOutputStream writer=new ObjectOutputStream(new FileOutputStream("student.bin"));
		for(Student student:stuList){
			writer.writeObject(student);
		}
		writer.close();
		ObjectInputStream reader=new ObjectInputStream(new FileInputStream("student.bin"));
		for(Student student:stuList){
		student=(Student) reader.readObject();
		System.out.println(student.num+"\t"+student.name+"\t"+student.sex);
		}
		reader.close();
	}

}
