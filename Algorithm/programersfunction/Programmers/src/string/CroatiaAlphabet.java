package string;

import java.util.Scanner;

public class CroatiaAlphabet {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String S = scan.next();

		char[] alphaSet = S.toCharArray();
		int length = alphaSet.length;

		for (int i = 0; i < alphaSet.length; i++) {
			String chk = CheckKroatia(alphaSet[i]);
			if (!chk.equals("x")) {
				if (i == alphaSet.length - 1) {
					break;
				}
				for (int k = 0; k < chk.length(); k++) {
					char[] chkK = chk.toCharArray();
					if (chk.length() == 2) {
						if (alphaSet[i + 1] == chkK[k]) {
							length--;
							if (i != 0) {
								if (alphaSet[i] == 'z' && alphaSet[i - 1] == 'd' && alphaSet[i + 1] == '=') {
									length++;
								}
							}
						}
					} else if (chk.length() == 3) {
//						if (alphaSet[i + 1] == chkK[0]) {
//							if (alphaSet[i] != alphaSet.length - 2) {
//								break;
//							}
//							if (alphaSet[i + 2] == chkK[1])
//								length -= 2;
//							break;
//						} else if (alphaSet[i + 1] == chkK[2]) {
//							length--;
//							if (i == alphaSet.length - 2) {
//								break;
//							}
//						}
					}
				}

			}
		}
		System.out.println(length);
	}

	public static String CheckKroatia(char key) {
		String checkKey;
		switch (key) {
		case 'c':
			checkKey = "=-";
			break;
		case 'd':
			checkKey = "z=-";
			break;
		case 'l':
			checkKey = "1j";
			break;
		case 'n':
			checkKey = "1j";
			break;
		case 's':
			checkKey = "1=";
			break;
		case 'z':
			checkKey = "1=";
			break;
		default:
			checkKey = "x";
			break;
		}

		return checkKey;
	}
}
