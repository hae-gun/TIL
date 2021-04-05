package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StartAndLink {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.valueOf(br.readLine());
		
		int S[][] = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String[] line = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				S[i][j] = Integer.valueOf(line[j]);
			}
		}
		System.out.println(System.currentTimeMillis());
		int result = solution(S,N);
		System.out.println(result);
		System.out.println(System.currentTimeMillis());
		
	}

	private static int solution(int[][] s, int N) {
		
		int min = 987654321;
		
		Combination comb = new Combination(N, N/2);
		int[] set = new int[N];
		Set<Integer> allNumber = new HashSet<>();
		for(int i=0; i<set.length; i++) {
			set[i] = i+1;
			allNumber.add(set[i]);
		}
		List numbers = Arrays.asList(allNumber.toArray());
		
		comb.combination(set, 0, 0, 0);;
		
		for(List<Integer> list : comb.getResult()) {
			Set temp = new HashSet<Integer>(numbers);
			
			for(int num : list) {
				temp.remove(num);
			}
			Combination comb2 = new Combination(list.size(), 2);
			
			int a[] = listToArray(list);
			comb2.combination(a, 0, 0, 0);
			
			Combination comb3 = new Combination(temp.size(), 2);

			int[] b = listToArray(temp);
			comb3.combination(b, 0, 0, 0);
			
			
			int start = getPoint(0, s, comb2);
			int link = getPoint(0, s, comb3);
			
			min = Math.min(min, Math.abs(start-link));
		}
		
		
		
		return min;
	}

	public static int getPoint(int sum, int[][] map,Combination comb) {
		for(List<Integer> t : comb.getResult()) {
			sum += map[t.get(0)-1][t.get(1)-1];
			sum += map[t.get(1)-1][t.get(0)-1];
		}
		return sum;
	}
	
	public static int[] listToArray(Collection<Integer> list) {
		int result[] = new int[list.size()];
		List temp = null;
		if(list instanceof List) {
			temp = (ArrayList<Integer>)list;
		}else if(list instanceof Set) {
			temp = new ArrayList<Integer>(list);
		}
		
		
		for(int i=0; i<temp.size(); i++) {
			result[i] = (int) temp.get(i);
		}
		
		return result;
	}
}


class Combination { 
	private int n;
	private int r;
	private int[] now;
 // 현재 조합 
	private ArrayList<ArrayList<Integer>> result;
 // 모든 조합 
	
	public ArrayList<ArrayList<Integer>> getResult() { 
		return result;
	} 

	public Combination(int n, int r) { 
		this.n = n;
		this.r = r;
		this.now = new int[r];
		this.result = new ArrayList<ArrayList<Integer>>();
	
	 } 
	
	public void combination(int[] arr, int depth, int index, int target) { 
		if (depth == r) { 
			ArrayList<Integer> temp = new ArrayList<>();
			for (int i = 0;i < now.length;i++) { 
					temp.add(arr[now[i]]);
				} result.add(temp);
				return;
		} 
		if (target == n) return;
	
		now[index] = target;
	
		combination(arr, depth + 1, index + 1, target + 1);
		combination(arr, depth, index, target + 1);
	 } 
}