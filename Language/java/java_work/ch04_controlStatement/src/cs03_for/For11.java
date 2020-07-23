package cs03_for;

public class For11 {
	public static void main(String[] args) {
		// 주사위 두개의 합
		
		for(int i=1; i<7; i++) {
			for(int j=1; j<7; j++) {
				if(i+j==6) {
					System.out.printf("1번: %d, 2번: %d, 합: %d\n",i,j,i+j);
				}
			}
		}
	}
}
