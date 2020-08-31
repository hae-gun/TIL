package blend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_4 {

	static int[][] map;

	static int[][] visited;
	
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		int size = Integer.parseInt(input[0]);
		int range = Integer.parseInt(input[1]);
		int count=1;
		
		map = new int[size][size];
		
		for(int i=0; i<size; i++) {
			String tmp = br.readLine();
			String[] num = tmp.split(" ");
			for(int j=0; j<size; j++) {
				map[i][j] = Integer.parseInt(num[j]);
			}
		}
		
		
		
		
		visited = new int[size][size];
		
		for (int i = 0; i < size; i++) {
			
			for (int j = 0; j < size; j++) {
				
				
				if (map[i][j] == 0) {

					count = Math.max(count, bfs(size, i, j, range,count));
					resetVisited(size);
				}
			}

		}
		
		System.out.println(count);

	}

	private static void resetVisited(int size) {
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				visited[i][j]=0;
			}
		}
	}

	private static int bfs(int size, int x, int y,int range,int count) {
		
		if(range==0) {
			return count;
		}

		for(int dir=0; dir<4; dir++) {
			int nx = x+dx[dir];
			int ny = y+dy[dir];
			
			if(map[nx][ny]==0 && visited[nx][ny]==0) {
				visited[nx][ny] = 1;
				count++;
			}
		}
		
		
		
		
		return 0;
		
	}
}
