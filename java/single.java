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
			System.out.println("tianchong");
			empty=false;
		}
		
	}
	public void boil(){
		if(!isBoiled()&&!isEmpty()){
			System.out.println("zhufei");
			boiled=true;
		}
		
	}
	public void drain(){
		if(!isEmpty()&&isBoiled()){
			System.out.println("daochuhunhewu");
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
			System.out.println(x);
			switch(x%3)
			{
				case 0:ChocolateBoiler.fill();break;
				case 1:ChocolateBoiler.boil();break;
				case 2:ChocolateBoiler.drain();break;
			}
			
		}
		
	}
}
