package cs04_while_doWhile;

/*
 * do{
 * 
 * 조건과 관계없이 일단 1번 실행.
 * 
 * }while(조건);
 * 
*/

public class DoWhile01 {
	public static void main(String[] args) {
		
		int num=1;
		int sum=0;
		
		while(num<=10) {
			sum+=num;
			num++;
		}
		System.out.println("sum: "+sum);
		System.out.println("==========");
		num=1; sum=0;
		do {
			sum += num;
			num++;
		} while (num <= 10);
		System.out.println("sum: "+sum);
	}
}
