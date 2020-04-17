package string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CountAlphabet {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// Input
		String input = br.readLine().trim();

		int[] alphabetIndex = new int[26];

		for (int i = 0; i < alphabetIndex.length; i++) {
			alphabetIndex[i] = -1;
		}

		for (int i = 0; i < input.length(); i++) {

			if (alphabetIndex[input.charAt(i) - 'a'] == -1) {

				alphabetIndex[input.charAt(i) - 'a'] = i;

			}

		}
		String result = "";
		for (int i = 0; i < alphabetIndex.length; i++) {
			if (i == 0) {
				result = String.valueOf(alphabetIndex[i]);
				result += " ";
			} else if (i == alphabetIndex.length - 1) {
				result += String.valueOf(alphabetIndex[i]);
			} else {
				result += String.valueOf(alphabetIndex[i]);
				result += " ";
			}

		}
		bw.write(result);
		bw.close();
		br.close();
	}

}
