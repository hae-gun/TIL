package string;

import java.util.Scanner;

public class Constant {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		StringBuffer s = new StringBuffer();
		
		s.append(scan.nextLine());
		
		String[] S = s.toString().split(" ");
		int[] reverseNum = new int[2];
		
		char[][] num = new char[2][];
		for(int i=0;i<num.length;i++) {
			num[i]=S[i].toCharArray();
		}
		
		StringBuffer temp = new StringBuffer();
		
		for(int i=0; i<num.length;i++) {
			for(int j=num[i].length-1; j>=0;j--) {
				temp.append(num[i][j]);
			}
			
			reverseNum[i]=Integer.valueOf(temp.toString());
			temp.delete(0, num[i].length);
		}
		
		System.out.println(Math.max(reverseNum[0],reverseNum[1]));
		
		
		
	}

}
