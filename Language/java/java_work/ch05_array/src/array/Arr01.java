package array;

public class Arr01 {
	//배열: 같은 타입의 여러 값을 하나의 묶음으로 다루는 효율적인 방법
	//정수 1000개: int num1 = 1, num2 = 2... 
	// -> 정수 1000칸 짜리 배열 1개를 만들어 처리 가능  
	
	public static void main(String[] args) {
		
		int[] n1; //Integer 배열 n1 선언 - 초기화 안 됨. 
		n1 = new int[1000]; //정수 공간 1000칸짜리 배열이 만들어지고 0으로 초기화
		System.out.println(n1[0]);
		
		//50칸짜리 float type 배열 선언하고 초기화(0.0)
		float[] f1;
		f1 = new float[50]; 
		float[] f2 = new float[50];
		System.out.println(f2[0]);
		
		//10칸짜리 char배열 c1 만들기
		char[] c1 = new char[10];
		System.out.println(c1[0]);// ' '로 초기화
		
		//10칸짜리 boolean배열 b1 만들기
		boolean[] b1 = new boolean[10];
		System.out.println(b1[0]); //false로 초기화
		
		//String 배열 5칸 선언 및 생성 s1
		String[] s1 = new String[5];
		System.out.println(s1[0]); //null로 초기화 ""
		
		
	}
}
