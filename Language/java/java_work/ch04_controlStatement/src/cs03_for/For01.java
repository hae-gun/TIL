package cs03_for;

/*
 * for(초기식; 반복조건; 증감식){
 *		수행할 명령; 
 * }
*/
public class For01 {
	public static void main(String[] args) {
		// 0/1/2/3/4/5/6/7/8/9/
		System.out.println("0/1/2/3/4/5/6/7/8/9/"); // for문을 이용하면
		System.out.println("---------------");
		for(int i=0; i<10; i++) {
			System.out.print(i+"/");
		}
		System.out.println();
		for(int i=5; i>0 ; i--) {
			System.out.print(i+"/"); // 0/1/2/3/4/5/6/7/8/9
		}
		System.out.println();
		for(int i=2; i<=10; i+=2) {
			System.out.print(i+"/"); // 2/4/6/8/10/
		}
		System.out.println();
		for (int i = 1; i < 10; i*=3) {
			System.out.println(i+"/"); // 1/3/9/
		}
		
	}
}
