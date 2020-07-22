
public class Op04 {
	
	
	public static void main(String[] args) {
		// 증감 연산자
		// ++ --
		
		int num = 10;
		System.out.println(num);
		num++;
		System.out.println(num);
		num--;
		System.out.println(num);
		
		// 전위증감, 후위증감 : 연산 우선순위 차이
		// 후위증감 : 대입 연산자보다 순위가 낮다.
		int num2 = 10;
		int num3 = num2++;
		System.out.printf("num2:%d, num3:%d\n",num2,num3);
		
		int tmp = 10;
		System.out.printf("%d %d %d %d %d\n",tmp++,++tmp,tmp--,++tmp,tmp++);
		System.out.println(tmp);
	}

}
