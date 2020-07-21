package dataType;

public class Printf {
	public static void main(String[] args) {
		
		// printf : 출력 타입 지정하고 뒤에 순서대로 붙여줌
		/*
		 * 타입 지정 : %c - char/ %s - String/ %d - Integer
		 * 			%f - 실수 / %b - boolean
		 *  \(이스케이프 문자) : \n - 줄바꿈 (enter키)
		 *  				 \t - tab
		 *  				 \\ -  백슬레시
		 */
		System.out.println("문자" + 'A'+" 의 유니코드 값은 "+(int)'A');
		System.out.printf("문자%c 의 유니코드 값은 %d\n",'A',(int)'A');
		System.out.printf("문자%c 의 유니코드 값은 %d\n",'글',(int)'글');
		
		System.out.printf("3자리 숫자: %d는 %s다 => %b\n",379,"짝수",false);
		System.out.printf("열 자리에 3자리 숫자 %10d를 오른쪽 정렬\n",379);
		System.out.printf("열 자리에 3자리 숫자 %-10d를 왼쪽 정렬\n",379);
		System.out.printf("열 자리에 3자리 숫자 %010d를 오른쪽 정렬 빈자리 0\n",379);
		System.out.printf("%f를 소숫점 2째자리까지 반올림 하면 %.2f 가 됩니다.\n",3.14512,3.14);
		System.out.printf("%f를 정수 다섯자리, 소숫점 2째자리까지 반올림하면 &7.2f가 됩니다.\n",3423.1415920,3423.1415920);
	}
}
