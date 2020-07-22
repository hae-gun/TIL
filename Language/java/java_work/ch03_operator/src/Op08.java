import java.io.IOException;

public class Op08 {

	public static void main(String[] args) throws IOException {
		// 3항식 : 조건식 ? true일 때의 실행문 : false일 때의 실행문
		System.out.println("1~9 숫자입력>>");
		int num = System.in.read() - '0';
		
		if (num % 2 ==0) {
			System.out.printf("%d 는(은) 짝수입니다.",num);
		}else {
			System.out.printf("%d 는(은) 홀수입니다.",num);
		}
		
		System.out.printf("%d 는(은) %s입니다.",num, num%2==0?"짝수":"홀수");
	}

}
