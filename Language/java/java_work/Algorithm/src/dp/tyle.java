package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class tyle {
	
	static int totalBlock=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = (br.readLine()).split(" ");
		int r = Integer.parseInt(input[0]);
		int c = Integer.parseInt(input[1]);
		int k = Integer.parseInt(input[2]);

		String[] blocks = new String[k];
//		long[][] blockMap = new long[r][c];
		HashMap<Integer, ArrayList<Integer>> map = new HashMap();

		for (int i = 0; i < k; i++) {
			blocks[i] = br.readLine();
			int row = Integer.parseInt(blocks[i].split(" ")[0]);
			int col = Integer.parseInt(blocks[i].split(" ")[1]);
			if (map.containsKey(row)) {
				ArrayList<Integer> temp = map.get(row);
				temp.add(col-1);
				map.put(row, temp);
			} else {
				ArrayList<Integer> temp = new ArrayList<>();
				temp.add(col-1);
				map.put(row, temp);
			}
		}
//		for(int i=1; i<r; i++) {
//			if(!map.containsKey(i)) {
//				map.put(i, null);
//			}
//		}
		long result = 1L;
		for (int a : map.keySet()) {
//			if(map.get(a)!=null) {
				List<Integer> temp = map.get(a);
				int[] numset = toArray(temp);
				long partResult = countBlock(numset,c);
				result *= partResult;
//			}else {
//				if(c%2!=0) {
//					result *= c/2 +1;
//				}
//			}
//			System.out.println(""+result);
		}
		System.out.println(map.keySet().size());
		System.out.println(c/2+1);
		
		if(c%2!=0) {
			result *= (int)(Math.pow((c/2 +1), r-map.keySet().size()));
		}
		
		
		
		System.out.println("result: "+result%1000000007);

	}
	
	private static long countBlock(int[] numset,int lastIndex) {
		Arrays.sort(numset);
		long result = 1;
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		for(int i:numset) {
			list.addLast(i);
		}
		
		int pre = list.removeFirst();
		if(pre>2) {
			result *= pre/2 +1;
		}
		
		while(!list.isEmpty()) {
			int number = list.removeFirst();
			int count = number-pre-1;
			
			if(!list.isEmpty()) {
				if(count>2) {
					result *= countResult(count);
				}
			}else {
				count = lastIndex-number-1;
				if(count>2) {
					result *=countResult(count);
				}
			}
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

	public static int countResult(int length) {
		int result = 1;

		if (length % 2 != 0) {
			result = length / 2 + 1;
		}

		return result;
	}

}
