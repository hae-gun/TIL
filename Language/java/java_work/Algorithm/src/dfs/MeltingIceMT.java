package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MeltingIceMT {
	
	static int[][] map;
	static int[][] melt;
	static int[][] visited;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args){
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String set="";
		try {
			set = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] rowCol = set.split(" ");
		int row = Integer.parseInt(rowCol[0]);
		int col = Integer.parseInt(rowCol[1]);
		
		map = new int[row][col];
		melt = new int[row][col];
		visited = new int[row][col];
		
		for(int i=0;i<row;i++) {
			String line="";
			try {
				line = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			String[] temp = line.split(" ");
			for(int j=0; j<col;j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		solution(row,col);
		
	}

	private static void solution(int row, int col) {
		int year = 0;
		while(true) {
			// 빙산 조각수
			int count=0;
			
			//탐색
			for(int i=0;i<row;i++) {
				for(int j=0; j<col; j++) {
					// 방문하지 않은 0이 아닌 곳에서 dfs수행
					if(visited[i][j]==0 && map[i][j]!=0) {
						dfs(row,col,i,j);
						// 빙산 조각+1
						count++;
						}
					}
			}
			if(count==0) {
				// 조각이 나눠지지 않고 모두 녹은 경우!
				System.out.println(0);
				break;
			}else if(count>=2) {
				// 2개 이상으로 빙산이 조각난 경우!
				System.out.println(year);
				break;
			}
			// count=1 인 경우는 현재 빙산이 1조각으로 구성되었다는 의미이다.
			melting(row,col);
			 // 아직 빙산이 1조각 이므로 내년으로 넘어감!
			year++;
		}
		
	}

	private static void dfs(int row, int col,int x,int y) {
		visited[x][y] = 1;
		// 4방향 체크
		for(int dir=0; dir<4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			// 맵 안에 존재하는지 체크.
			if(nx>=0&&nx<row&&ny>=0&&ny<col) {
				//	주변 0 갯수만큼 내년에 녹음
				if(map[nx][ny]==0) {
					melt[x][y]++;
				}
				
				//dfs 수행
				// 아직 방문하지 않은 다음노드가 0이 아니면 수행
				if(visited[nx][ny]==0 && map[nx][ny]!=0)
					dfs(row,col,nx,ny);
			}
		}
	}
	
	private static void melting(int row, int col) {
		for(int i=0;i<row; i++) {
			for(int j=0; j<col; j++) {
				map[i][j] -= melt[i][j];
				//map 음수가 될시 0으로 만들어 준다.
				if(map[i][j]<0) {
					map[i][j]=0;
				}
				//다음 순회를 위한 초기화
				visited[i][j] = 0;
				melt[i][j]=0;
			}
		}
		
	}

}
