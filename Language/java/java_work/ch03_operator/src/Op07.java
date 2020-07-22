
public class Op07 {

	public static void main(String[] args) {
		// shift 연산자
		// <<: left 연산자
		// >>: right 연산자
		int n1 = 5;
		
		System.out.println(n1<<1);
//		 5 : 0000 0101
//		<<1: 0000 1010
//		빈 칸에는 0이 들어온다.
//		left 연산자: 좌항 변수값에 2의 n승을 곱한 결과
		
		System.out.println(n1>>2);
//		right 연산자: 좌항 변수값에 2의 n승을 나눈 결과
//		 5 : 0000 0101
//		>>2: 0000 0001
		
	}

}
