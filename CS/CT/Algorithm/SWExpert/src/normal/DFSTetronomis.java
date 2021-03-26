package normal;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DFSTetronomis {

	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int result = 0;
	static int n,m;
	static boolean[][] check;
	static int[][] map;
	// ㅜ ㅗ ㅏ ㅓ 순서쌍
	static int[][] ex = { {0,0,0,1},{1,1,1,0},{0,1,2,1},{0,1,2,1}};
	static int[][] ey = { {0,1,1,2},{0,1,1,2},{0,0,0,1},{1,1,1,0}};
	
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nm = br.readLine().split(" ");
		n = Integer.valueOf(nm[0]);
		m = Integer.valueOf(nm[1]);
		map = new int[n][m];
		check = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			String[] line = br.readLine().split(" ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.valueOf(line[j]);
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				check[i][j] = true;
				dfs(i,j,map[i][j],1);
				check[i][j] = false;
				
				excepShape(i, j);
				
			}
		}
		
		System.out.println(result);
		
	}
	
	
	
	static void dfs(int x, int y, int sum ,int depth) {
		if(depth>=4) {
			result = Math.max(result, sum);
			return;
		}else {
			int nx,ny;
			
			for(int dir=0; dir<4; dir++) {
				nx = x + dx[dir];
				ny = y + dy[dir];
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
					continue;
				}
				
				if(!check[nx][ny]) {
					check[nx][ny] = true;
					dfs(nx,ny,sum + map[nx][ny],depth+1);
					
					check[nx][ny] = false;
				}
				
			}
//			System.out.println(sum);
			
		}
	}
	static void excepShape(int x, int y) {
		
		int nx, ny, sum;
		boolean outCheck = false;
		
		for(int i = 0; i<4; i++) {
			sum = 0;
			outCheck = false;
			for(int j=0; j<4; j++) {
				nx = x + ex[i][j];
				ny = y + ey[i][j];
				if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
					outCheck = true;
					continue;
				}
					sum += map[nx][ny];
				
			}
			if(!outCheck)
				result = Math.max(result, sum);
		}
		
		
		
	}

}
