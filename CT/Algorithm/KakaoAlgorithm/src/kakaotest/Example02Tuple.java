package kakaotest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Example02Tuple {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
		
		int[] result = solution(line);
		for(int re : result) {
			System.out.println(re);
		}
		
	}
	public static int[] solution(String line) {
		
		char[] s = line.toCharArray();
		LinkedList<ArrayList<Integer>> set = new LinkedList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		StringBuffer stemp = new StringBuffer();
		for(int i=0; i<s.length; i++) {
			if(s[i]!='{') {
				if((s[i]>='0' && s[i]<='9')) {
					stemp.append(s[i]);
				}else{
					if(stemp.length()!=0) {
					temp.add(Integer.valueOf(stemp.toString()));
					stemp.delete(0, stemp.length());
					}
				}
				
				if(s[i]=='}') {
					set.add(temp);
					temp = new ArrayList<Integer>();
				}
				
				
			}
		}

		
		Collections.sort(set, new Comparator<ArrayList<Integer>>() {
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				int r1 = o1.size();
				int r2 = o2.size();
				
				if(r1 > r2)
					return +1;
				else
					return -1;
			};
		});
		
		ArrayList<Integer> tempResult = new ArrayList<Integer>();
		
		for(ArrayList<Integer> ss : set) {
			for(int i=0; i<ss.size(); i++) {
				if(!tempResult.contains(ss.get(i))) {
					tempResult.add(ss.get(i));
				}
			}
			
		}

		
		int[] result = new int[tempResult.size()];
		
		for(int i=0; i<tempResult.size(); i++) {
			result[i] = tempResult.get(i);
		}
		return result;
	}

}
