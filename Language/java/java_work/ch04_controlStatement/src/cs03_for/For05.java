package cs03_for;

public class For05 {
	public static void main(String[] args) {
		int i,j;
		
		for (i=1, j=10;i<=10; i++,j--) {
			System.out.printf("i: %d \t j: %d \n",i,j);
			System.out.println(i + " 번 일했음");
			
		}
		
		System.out.printf("for 문 빠져나올 떄의 i: %d \t j: %d",i,j);
		
	}
}
