package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Slope {
	static int[][] map;
	static int L;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NL = br.readLine().split(" "); 
		int N = Integer.valueOf(NL[0]);
		map = new int[N][N];
		L = Integer.valueOf(NL[0]);
		
		for(int i=0; i<N; i++) {
			String[] line = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.valueOf(line[j]);
			}
		}
		solve();
		
		
	}
	static int result=0;
	private static void solve() {
		for(int i=0; i<map.length; i++) {
			slope(i,true);
			slope(i,false);
			
		}
		System.out.println(result);
	}
	private static void slope(int i, boolean flag) {
		int count = 1;
		for(int j=0; j<map.length-1; j++) {
			int d = flag ? map[i][j+1] - map[i][j] : map[j+1][i] - map[j][i];
			if(d==0) count++;
			else if(d==1 && count >= L) count=1;
			else if ( d==-1 && count >= 0) count = -L +1;
			else return;
		}
		if(count >= 0) result += 1;
	}
}
