package class03_method;

public class Parameter {
	
	// 매개변수 2개 받아서 x~y 합계 구하는 매서드.
	int sum1(int x, int y) {
		int num = 0;

		for (int i = x; i <= y; i++) {
			num += i;
		}
		return num;
	}
	
	int sum1(int[] values) {
		int num = 0;

		for (int i = 0; i <values.length; i++) {
			num += values[i];
		}
		return num;
	}
	
	// 매개변수 갯수와 무관하게 받는 경우 values는 배열로 취급.
	int sum2(int ... values) {
		int num = 0;

		for (int i = 0; i <values.length; i++) {
			num += values[i];
		}
		return num;
	}
	
	void myClass(String[][] myClass) {
		int line =0;
		for(String[] row:myClass) {
			line++;
			System.out.println(line+"분단");
			for(String col : row) {
				System.out.printf(col+" ");
			}
		}
	}
	
}
