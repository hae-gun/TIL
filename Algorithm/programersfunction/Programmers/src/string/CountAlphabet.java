package string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class CountAlphabet {

	// 백준 10809번 문제
//	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		String S = scan.next();
//		}
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// Input
		String input = br.readLine().trim();

		// 알파벳 위치 체크 배열.
		int[] alphabetIndex = new int[26];

		// 배열 -1로 초기화. (-1 의미 : 나온적 없는 알파벳.)
		for (int i = 0; i < alphabetIndex.length; i++) {
			alphabetIndex[i] = -1;
		}

		// input 에서 알파벳이 나온 첫번째 index 찾기.
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
