package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TyleRetry {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = (br.readLine()).split(" ");
		int r = Integer.parseInt(input[0]);
		int c = Integer.parseInt(input[1]);
		int k = Integer.parseInt(input[2]);

		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

		for (int i = 1; i <= k; i++) {
			String s = br.readLine();
			int line = Integer.parseInt(s.split(" ")[0]);
			int number = Integer.parseInt(s.split(" ")[1]);

			if (map.containsKey(line)) {
				ArrayList<Integer> temp = map.get(line);
				temp.add(number);
				map.put(line, temp);
			} else {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(number);
				map.put(line, temp);
			}
		}

		// block counting
		long b_count = countBlock(r, c, map);

		// situation counting
		long s_count = countSituation(r, c, map) % 1000000007;
//		System.out.println(test);
		long divConst = 1000000007L;
		System.out.println(b_count + " " + s_count % divConst);
//		System.out.println(s_count % 1000000007);

	}

	private static long countSituation(int row, int col, HashMap<Integer, ArrayList<Integer>> map) {
		long result = 1L;

		for (int a : map.keySet()) {
			List<Integer> temp = map.get(a);
			int[] numset = toArray(temp);
			long partResult = countingSituation(numset, col);
			result *= partResult;
//			System.out.println("result in for: " + result);
		}
//		System.out.println("result in countSituation: " + result);
//		System.out.println(map);
		if (col % 2 != 0) {
			result *= (long) (Math.pow((col / 2 + 1), row - map.keySet().size()));
		}
//		System.out.println(result);
		return result;
	}

	private static long countingSituation(int[] numset, int col) {
		long result = 1;

		Arrays.sort(numset);

		LinkedList<Integer> list = new LinkedList<Integer>();

		for (int i : numset) {
			list.addLast(i);
		}
//		System.out.println("list in countBlock: " + list);

		while (!list.isEmpty()) {
			int preIndex = list.removeFirst();
			int length = preIndex - 1;
			int curIndex = preIndex;
//			System.out.println("length in whie: "+length);
			result = checkLength(result, length);
//			System.out.println("result next first: "+result);
			if (!list.isEmpty()) {
//				System.out.println("result in countBlock: " + result);
				curIndex = list.removeFirst();

				length = curIndex - preIndex - 1;
				preIndex = curIndex;

				result = checkLength(result, length);

			}
			// 현재 인덱스가 마지막 일 경우 맨 끝자리와 비교하기.
			if (list.isEmpty()) {

				length = col - curIndex;
				result = checkLength(result, length);

			}
//			System.out.println("result in while: "+result);
		}

		return result;
	}

	private static long checkLength(long result, int length) {
//		System.out.println("result in checkLength before if: " + result);
		if (length > 1 && length % 2 != 0) {
			result *= length / 2 + 1;
		}
//		System.out.println("result in checkLength before after: " + result);
		return result;
	}

	private static long countBlock(int row, int col, HashMap<Integer, ArrayList<Integer>> map) {
		long result = 0;

		for (int index : map.keySet()) {
			List<Integer> temp = map.get(index);
			int[] line = toArray(temp);
			result += countingBlock(line, col);
			
		}

		long blocks = col / 2;
		long cleanLine = row - map.size();
		result += blocks * cleanLine;

		return result;
	}


	private static long countingBlock(int[] line, int col) {
		long result = 0;
		Arrays.sort(line);
		
		int preIndex = line[0];
		long length = preIndex-1;
		if(length>1) {
			result += length/2;
		}
		
		
		for(int i=1; i<line.length; i++) {
			int curIndex = line[i];
			length = curIndex - preIndex-1;
			if(length>1) {
				result += length/2;
			}
			preIndex = curIndex;
			
		}
		length = col - preIndex;
		if(length>1) {
			result += length/2;
		}
		
		return result;
	}

	private static int[] toArray(List<Integer> temp) {
		int length = temp.size();

		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			result[i] = temp.get(i);
		}

		return result;
	}

}
