package string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GroupWord {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 그룹단어 : 현재위치의 글자가 앞 문자와 같지 않은데 뒤에 문자와 같은경우 해당 단어는

		int tcase = Integer.valueOf(br.readLine());
		String input;
		int result = 0;

		for (int i = 0; i < tcase; i++) {
			input = br.readLine().trim();
			if (checkGroup(input)) {
				result++;
			}

		}
		bw.write(String.valueOf(result));
		bw.flush();
		br.close();
		bw.close();

	}

	public static boolean checkGroup(String input) {
		boolean[] alphabet = new boolean[26]; // 각 번호는 알파벳을 의미. 해당 칸이 true인 경우 : 해당문자가 다시 나온경우.

		for (int i = 0; i < input.length(); i++) {
			char temp = input.charAt(i);
			if (alphabet[temp - 'a']) {
				return false;
			} else { // 해당 단어가 계속 연속되면 그 해당 단어의 alphabet 배열값은 false이다. 그러다가 뒤에 다른단어가 나타나면 true로 변경됨.
						// 그후 해당 단어가 다시 나타나게 되면 그 단어는 그룹단어가 아님. 따라서 위에 if 문 로직에 걸려 false 를 리턴.
				if (i < input.length() - 1 && temp != input.charAt(i + 1)) {
					alphabet[temp - 'a'] = true;
				}
			}

		}

		return true;
	}

}
