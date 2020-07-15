package ProgrammersLevel2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StockPrice {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] input = { 1, 2, 3, 2, 3 };

		int[] output = solution(input);
		bw.append("input:");
		for (int i : input) {
			bw.append(String.valueOf(i));
		}
		bw.append("\n");
		bw.append("output:");
		for (int i : output) {
			bw.append(String.valueOf(i));
		}
		// bw.flush();
		bw.close();
		br.close();
	}

	public static int[] solution(int[] prices) {
		int[] result = new int[prices.length];
		for (int i = 0; i < result.length-1; i++) {
			// input 의 숫자가 index 까지 가격까지 떨어지나 안떨어지나 확인.
			// 해당 index 안떨어진 시간.
			for (int j = i; j < result.length; j++) {
				result[i] = j - i;
				if (prices[i] > prices[j]) {
					break;
				}
			}
		}
		return result;
	}
}
