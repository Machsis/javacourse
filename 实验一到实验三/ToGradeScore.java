public class ToGradeScore{
	public static void main(String[] args) {
		System.out.println("请输入成绩")；
		int[] a={
			60,
			70,
			80,
			90
		}
		String[] b;
		while(数组取值不为空){
			
			if(score>90){
				b+="优";
			}
			else if(score>80){
				b+="良";
			}
			else if(score>70){
				b+="中";
			}
			else if(score>60){
				b+="及格";
			}
			else{
				b+="不及格";
			}
		}
		System.out.println(b);
	}
}