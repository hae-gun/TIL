package array;

//정수 2차원 배열 3*3짜리 생성해서 값 넣고 일반 for, 확장 for로 출력
//출력 끝에서 sum, avg, max, min 출력
public class Arr06 {
	public static void main(String[] args) {
		int[][] num = {{77, 69, 93},
					{88, 69, 72},
					{59, 82, 100}};
		int sum=0, max=num[0][0], min=num[0][0];
		double avg;
		
		System.out.println("======== 확장 for 문 ==========");
		for (int[] row : num) {
			for(int col : row) {
				System.out.print(col+ ", ");
			}
			System.out.println();
		}
		System.out.println("======== sum, avg, max, min ==========");
		int numberOfStudents=0;
		for(int i = 0; i<num.length; i++) {
			numberOfStudents += num[i].length;
			for(int j = 0; j < num[i].length; j++ ) {
				//numberOfStudents++;
				sum += num[i][j];
				if(max < num[i][j]) {
					max = num[i][j];
				}
				if(min > num[i][j]) {
					min = num[i][j];
				}
			}
		}
		//System.out.println(numberOfStudents);
		avg = sum / (double)numberOfStudents;
		System.out.printf("총점: %d, 평균: %.2f\n", sum, avg);
		System.out.printf("=> 1등의 점수는 %d점이고 꼴찌의 점수는 %d입니다.\n", max, min);
	}
}
