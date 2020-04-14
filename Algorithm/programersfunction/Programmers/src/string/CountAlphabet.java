package string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CountAlphabet {

	// ���� 10809�� ����
//	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		String S = scan.next();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// Input
		String input = br.readLine().trim();

		// ���ĺ� ��ġ üũ �迭.
		int[] alphabetIndex = new int[26];

		// �迭 -1�� �ʱ�ȭ. (-1 �ǹ� : ������ ���� ���ĺ�.)
		for (int i = 0; i < alphabetIndex.length; i++) {
			alphabetIndex[i] = -1;
		}

		// input ���� ���ĺ��� ���� ù��° index ã��.
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
