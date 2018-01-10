/**
 * 
 */
package com.java.test1;

/**
 * @author lm
 *
 */
public  class  SingleCase implements Runnable{
	private boolean empty;
	private boolean boiled;
	public int ID;
	private static SingleCase uniqueInstance;
	public static SingleCase getInstance(){
		if(uniqueInstance==null){
			uniqueInstance=new SingleCase();
		}
		return uniqueInstance;
	}

	public void run() {
		SingleCase ChocolateBoiler=SingleCase.getInstance();
		ChocolateBoiler.ID=this.ID;
		ChocolateBoiler.fill();
		ChocolateBoiler.boil();
		ChocolateBoiler.drain();
	}
	SingleCase(){
		empty = true;
		boiled = false;
	}
	SingleCase(int id) {

		this.ID=id;
	}

	public void fill() {
		synchronized (this) {
			if (isEmpty()) {
				System.out.println("线程"+this.ID+"正在填充");
				empty = false;
			}
		}
		
	}

	public void boil() {
		synchronized (this) {
			if (!isBoiled() && !isEmpty()) {
				System.out.println("线程"+this.ID+"正在煮沸");
				boiled = true;
			}
		}

	}

	public void drain() {
		synchronized (this) {
			if (!isEmpty() && isBoiled()) {
				System.out.println("线程"+this.ID+"倒出混合物");
				empty = true;
				boiled = false;
			}
		}
	}
	public boolean isEmpty(){
		return empty;
	}
	public boolean isBoiled(){
		return boiled;
	}
	public static void main(String[] args) {

		Thread []thread=new Thread[3];
		for (int i=0;i<3 ;i++ ) {
			thread[i]=new Thread(new SingleCase(i+1));
			thread[i].start();		
		}
		
	}
}
