
public class Op02 {
	public static void main(String[] args) {
		// 비교 연산자 : 결과값을 boolean type(true, false)로 반환한다.
		// <, >, <=, >=, ==, !=
		int n1 = 33;
		int n2 = 10;
		boolean result;
		
		result = n1>n2;
		System.out.printf("%d %c %d = %b \n",n1,'>',n2,result);
		result = n1<n2;
		System.out.printf("%d %c %d = %b \n",n1,'<',n2,result);
		result = n1>=n2;
		System.out.printf("%d %s %d = %b \n",n1,">=",n2,result);
		result = n1<=n2;
		System.out.printf("%d %s %d = %b \n",n1,"<=",n2,result);
		result = n1==n2;
		System.out.printf("%d %s %d = %b \n",n1,"==",n2,result);
		result = n1!=n2;
		System.out.printf("%d %s %d = %b \n",n1,"!=",n2,result);
	}
}
