package com.java.test2;
public  class  single{
	private boolean empty;
	private boolean boiled;
	private static single uniqueInstance;
	public static single getInstance(){
		if(uniqueInstance==null){
			uniqueInstance=new single();
		}
		return uniqueInstance;
	}
	single(){empty=true;boiled=false;}
	public void fill(){
		if(isEmpty()){
			System.out.println("填充");
			empty=false;
		}
		
	}
	public void boil(){
		if(!isBoiled()&&!isEmpty()){
			System.out.println("煮沸");
			boiled=true;
		}
		
	}
	public void drain(){
		if(!isEmpty()&&isBoiled()){
			System.out.println("倒出");
			empty=true;
			boiled=false;
		}
		
	}
	public boolean isEmpty(){
		return empty;
	}
	public boolean isBoiled(){
		return boiled;
	}
	public static void main(String[] args) {
		single ChocolateBoiler=single.getInstance();		
		for (int i=0;i<30 ;i++ ) {
			int x=(int)(Math.random()*10);
			switch(x%3)
			{
				case 0:ChocolateBoiler.fill();break;
				case 1:ChocolateBoiler.boil();break;
				case 2:ChocolateBoiler.drain();break;
			}
			
		}
		
	}
}
