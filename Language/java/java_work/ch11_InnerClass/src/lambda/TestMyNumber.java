package lambda;

public class TestMyNumber {

	public static void main(String[] args) {
	
		MyNumber bigger = new MyNumber() {
			
			@Override
			public int getMax(int x, int y) {
				// TODO Auto-generated method stub
				return (x>= y)? x:y;
			}
		};
		
		
		MyNumber max = (x, y)->(x>= y)? x:y; // 람다식을 인터페이스 자료형 max 변수에 대

		System.out.println(max.getMax(10, 20));// �������̽� �ڷ��� ������ �Լ� ȣ��
		
	//	MyNumber max2 = (x, y)-> x>=y ?x:y;
	//	System.out.println(max2.getMax(10, 20));
	}
}
