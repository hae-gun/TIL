package function;
import java.util.Scanner;

public class Example03_HanNumber {

	public static void main(String[] args) {

		int lastNum;
		Scanner scan = new Scanner(System.in);
		lastNum =scan.nextInt();
		int countHanSu = 0;

		for (int i = 1; i <= lastNum; i++) {
			int currentNum = i;
			String a = String.valueOf(i);
			char[] list = a.toCharArray();

			if (list.length < 3) {
				countHanSu++;
			}else {
				
				int gep1 = list[1]-list[0];
				int gep2 = list[2] - list[1];
				if(gep1==gep2) {
					countHanSu++;
				}
			}

		}
		System.out.println(countHanSu);
		
		
	}
	

}