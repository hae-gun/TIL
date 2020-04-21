package string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class CountAlphabet {

	// ¹éÁØ 10809¹ø ¹®Á¦
//	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		String S = scan.next();
//		}
	// ï¿½ï¿½ï¿½ï¿½ 10809ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
//	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		String S = scan.next();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// Input
		String input = br.readLine().trim();

		// ï¿½ï¿½ï¿½Äºï¿½ ï¿½ï¿½Ä¡ Ã¼Å© ï¿½è¿­.
		int[] alphabetIndex = new int[26];

		// ï¿½è¿­ -1ï¿½ï¿½ ï¿½Ê±ï¿½È­. (-1 ï¿½Ç¹ï¿½ : ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½Äºï¿½.)
		for (int i = 0; i < alphabetIndex.length; i++) {
			alphabetIndex[i] = -1;
		}

		// input ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½Äºï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ Ã¹ï¿½ï¿½Â° index Ã£ï¿½ï¿½.
		for (int i = 0; i < input.length(); i++) {
			
			
			if (alphabetIndex[input.charAt(i) - 'a'] == -1) {

				alphabetIndex[input.charAt(i) - 'a'] = i;
		

			}

		}
		String result="";
		for(int i =0 ; i < alphabetIndex.length; i++) {
			if(i==0) {
				result = String.valueOf(alphabetIndex[i]);
				result += " ";
			}else if(i==alphabetIndex.length-1) {
				result += String.valueOf(alphabetIndex[i]);
			}else {
				result += String.valueOf(alphabetIndex[i]);
				result += " ";
			}
			
		}
		bw.write(result);
		bw.close();
		br.close();
	}

}
