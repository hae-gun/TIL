package string;

import java.util.Scanner;

public class Dial {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String S = scan.next().toUpperCase();
		char[] alphaSet = S.toCharArray();

		int sum = 0;
		for (char a : alphaSet) {
			switch (a) {
			case 'A':
			case 'B':
			case 'C':
				sum+=3;
				break;
			case 'D':
			case 'E':
			case 'F':
				sum+=4;
				break;
			case 'G':
			case 'H':
			case 'I':
				sum+=5;
				break;
			case 'J':
			case 'K':
			case 'L':
				sum+=6;
				break;
			case 'M':
			case 'N':
			case 'O':
				sum+=7;
				break;
			case 'P':
			case 'Q':
			case 'R':
			case 'S':
				sum+=8;
				break;
			case 'T':
			case 'U':
			case 'V':
				sum+=9;
				break;
			case 'W':
			case 'X':
			case 'Y':
			case 'Z':
				sum+=10;
				break;

			default:
				break;
			}
		}
		
//		char[] numSet = Sb.toString().toCharArray();
//		for (int i = 0; i < numSet.length; i++) {
//			sum += (int)(numSet[i])-47;
//		}
		System.out.println(sum);
	}

}
