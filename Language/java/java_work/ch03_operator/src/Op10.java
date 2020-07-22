
public class Op10 {
	public static void main(String[] args) {
		
		
		int apple = 1; // 사과 1개
		double pieceUnit = 0.1; // 사과를 10개로 쪼갠 조각 중 1개
		
		int num = 7;
		double result = apple - pieceUnit*num;
		// 부동 소수점 오류
		System.out.println(result);
		
		// 사과 1개를 10개로 만들어 한 개씩 먹게 한 다음 다시 10분의 1로 만듬.
		int totalPieces = 10*apple;
		int temp = totalPieces - num;
		
		result = temp/10.0;
		System.out.println(result);

		result = temp*0.1;
		System.out.println(result);

	}
	
	
	//TODO: 내일하자, say()
	void say() {}

}
