package com.Test4;

import java.io.Serializable;

public class Student implements Serializable {
	private static final long serialVersionUID = 1234L;
	String num=null;
	String name=null;
	String sex=null;
	Student(String no,String a,String b){
		num=no;
		name=a;
		sex=b;
	}
}
