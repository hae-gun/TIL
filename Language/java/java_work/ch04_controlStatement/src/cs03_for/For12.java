package cs03_for;

public class For12 {
	public static void main(String[] args) {
		// 합계 구하기
		// 1~10
		int sum = 0;
		for (int i = 1; i < 11; i++) {
			sum += i;
		}
		System.out.println("1~10 합 : " + sum);
		System.out.println("================");

		sum = 0;
		for (int i = 1; i < 101; i++) {
			sum += i;
			if(i%10==0) {
				System.out.printf("1~%3d까지 합: %4d\n",i,sum);
			}
		}
		System.out.println("================");
		
	}
}
