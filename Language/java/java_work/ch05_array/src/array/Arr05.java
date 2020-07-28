package array;

//다차원 배열: 표 - 행과 열로 이루어짐 - 행렬

public class Arr05 {
	public static void main(String[] args) {
		// 3행 3열짜리 2차원배열 선언, 생성
		int[][] num = new int[3][3];
		
		// 가변형 배열: 1행 2열, 2행 3열 배열 생성
		int[][] num1 = new int[2][];
		num1[0] = new int[2];
		num1[1] = new int[3];
		
		System.out.println(num1.length); //행의 개수
		System.out.println(num1[0].length); //1행의 길이
		System.out.println(num1[1].length); //2행의 길이
		
		num1[0][0] = 11;
		num1[0][1] = 21;
		num1[1][0] = 31;
		num1[1][1] = 41;
		num1[1][2] = 51;
		
		System.out.println(num1);
		System.out.println(num1[0]);
		System.out.println(num1[1]);
		
		for(int i=0; i< num1.length; i++ ) {
			for(int j =0; j < num1[i].length; j++) {
				System.out.printf("num1[%d][%d] = %d \n", i,j, num1[i][j]);
			}
		}
		
		System.out.println("======== 확장 for 문 ==========");
		
		for(int row[] : num1) {
			for(int col : row) {
				System.out.printf("%d \t", col);
			}
			System.out.println("\n-----------------");
		}
		
		
		
		
		
		
		
		
		
	}
	
}
