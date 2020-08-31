package blend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2 {
	
	static int[] dx = { 1, 0 ,- 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] map;
	static int[][] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new int[N][N];
		for(int i=0;i<N;i++) {
			String line="";
			try {
				line = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			String[] temp = line.split(" ");
			for(int j=0; j<N;j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		
		

		int countSafety = 0;

		// 물과 사람 같이 이동함.
		// 현재위치에 벽 둘수 있다.
		int curWaterX = 0;
		int curWaterY = 0;

		int curHX = 0;
		int curHY = 0;
		//
		
		
		int count=0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				
				if(map[i][j]==0 && visit[i][j]==0) {
					
					dfs(N,i,j);
					count++;
					
				}
				
				
				
			}
		}
		System.out.println(count);

	}
	private static void dfs(int N, int x, int y) {
		visit[x][y] = 1;
		
		for(int dir=0; dir<4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			if(nx>=0&&nx<N&&ny>=0&&ny<N) {
				//	주변 0 갯수만큼 내년에 녹음
				//dfs 수행
				// 아직 방문하지 않은 다음노드가 0이 아니면 수행
				if(visit[nx][ny]==0 && map[nx][ny]==0)
					dfs(N,nx,ny);
			}
			
		}
		
		
	}

	

}
