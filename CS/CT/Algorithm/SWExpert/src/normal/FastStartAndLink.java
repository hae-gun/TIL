package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FastStartAndLink {

	static int N;
	static int[][] S;
	static boolean[] check;
	static int result = 987654321;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.valueOf(br.readLine());
		
		S = new int[N][N];
		check = new boolean[N];
		for(int i=0; i<N; i++) {
			String[] line = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				S[i][j] = Integer.valueOf(line[j]);
			}
		}
		
		solve(0,0);
		System.out.println(result);
	}

	private static void solve(int cnt, int idx) {
		if(idx == N) return;
		if(cnt == N/2) {
			int s1 = 0, s2 = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(check[i] && check[j]) s1 += S[i][j];
					if(!check[i] && !check[j]) s2 += S[i][j];
				}
			}
			result = Math.min(result, Math.abs(s1-s2));
		}
		check[idx] = true;
		solve(cnt+1,idx+1);
		check[idx] = false;
		solve(cnt,idx+1);
		
	}

}
