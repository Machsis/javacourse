public class hello{
	public static void main(String[] args) {
		int a=0;
		int i;
		for ( i=1990;i<2007;i++ ) {
			if(i/4==0&&i/100!=0 || i/400==0){
				System.out.println(i);
				a++;
			}
			if(a/2==0&&a!=0){
				System.out.println("\n");
			}
		}
	}
}