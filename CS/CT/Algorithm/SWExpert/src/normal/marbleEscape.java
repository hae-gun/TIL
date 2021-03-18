package normal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

public class marbleEscape {
	
	static class Status{
		int rx,ry;
		int bx,by;
		int step;
		
		public Status(int rx, int ry, int bx, int by, int step) {
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.step = step;
		}
	
		
	}
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	
	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] input = br.readLine().split(" ");
			
			int N = Integer.parseInt(input[0]);
			int M= Integer.parseInt(input[1]);
			
			int rsi = 0; // 공시작위치
			int rsj = 0;
			int bsi = 0;
			int bsj = 0;
			
			char[][] map = new char[N][M];
			// 맵 초기화
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				for(int j=0; j<M; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == 'R') {
						rsi=i;
						rsj=j;
					}
					if(map[i][j] == 'B') {
						bsi=i;
						bsj=j;
					}
					
				}
			}
			
			
			Queue<Status> q = new LinkedList<Status>();
			int[][][][] visited = new int[N][M][N][M];
			
			visited[rsi][rsj][bsi][bsj] = 1;
			q.offer(new Status(rsi, rsj, bsi, bsj, 0));
			
			while(!q.isEmpty()) {
				Status s = q.poll();
				
				if(s.step > 10) {
					System.out.println(-1);
					System.exit(0);
				}
				if(map[s.bx][s.by]=='O') {
					continue;
				}
				if(map[s.rx][s.ry] == 'O' && map[s.bx][s.by] != 'O') {
					System.out.println(s.step);
					System.exit(0);
				}
				for(int i=0; i<dx.length; i++) {
					int rni = s.rx;
					int rnj = s.ry;
					
					while(true) {
						rni += dx[i];
						rnj += dy[i];
						
						if(map[rni][rnj]=='O') break;
                        if(map[rni][rnj]=='#') {
							rni -= dx[i];
							rnj -= dy[i];
                            break;
					    }
					}
                    
					
					int bni = s.bx;
					int bnj = s.by;
					while(true) {
						bni += dx[i];
						bnj += dy[i];
						
						if(map[bni][bnj]=='O') break;
						if(map[bni][bnj]=='#') {
							bni -= dx[i];
							bnj -= dy[i];
                            break;
					    }
					}
                    
					
					// 두공 위치 같은경우
					if(rni == bni && rnj == bnj && map[rni][rnj] != 'O') {
						int redDistance = Math.abs(rni-s.rx) + Math.abs(rnj - s.ry);
						int blueDistance = Math.abs(bni-s.bx) + Math.abs(bnj - s.by);
						
						if(redDistance>blueDistance) {
							rni -= dx[i];
							rnj -= dy[i];
						}else {
							bni -= dx[i];
							bnj -= dy[i];
						}
					}
					if(visited[rni][rnj][bni][bnj]==0) {
						visited[rni][rnj][bni][bnj] = 1;
						q.offer(new Status(rni,rnj,bni,bnj,s.step+1));
					}
				}
			}
            System.out.println(-1);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}

