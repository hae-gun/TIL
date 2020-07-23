package cs03_for;

public class For02 {
	public static void main(String[] args) {
		int sum=0;
		for (int i=1; i<=10; i++) {
			sum += i;
			System.out.printf("1부터 %d 까지의 sum: %d\n",i,sum);
		}
	}

}
