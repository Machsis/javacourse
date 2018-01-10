class show{
	public static void main(String[] args) {
		int i=0,j=0;
		int n=8;
		for (;j<n ;) {
			for (;i<j+1 ; i++) {
			System.out.print("*");			
		}
			j+=2;
			System.out.print("/n");
		}
		for (;j>0 ; ) {
			for (;i<j+1 ; i++) {
			System.out.print("*");			
		}
			j-=2;
			System.out.print("/n");
		}
		
	}
}