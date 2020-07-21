
public class Op01 {

	public static void main(String[] args) {
		// 산술 연산자
		// +, -, *, /, %
		
		int n1 = 33;
		int n2 = 10;
		int result;
		
		result = n1+n2;
		System.out.printf("%d %c %d = %d \n",n1,'+',n2,result);
		result = n1-n2;
		System.out.printf("%d %c %d = %d \n",n1,'-',n2,result);
		result = n1*n2;
		System.out.printf("%d %c %d = %d \n",n1,'*',n2,result);
		result = n1/n2;
		System.out.printf("%d %c %d = %d \n",n1,'/',n2,result); // '/' 는 몫만 반환
		result = n1%n2;
		System.out.printf("%d %c %d = %d \n",n1,'%',n2,result); // '%' 는 나머지를 반환
	}

}
