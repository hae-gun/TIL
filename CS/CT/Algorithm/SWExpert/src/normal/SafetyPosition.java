package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;


public class SafetyPosition {
		
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.valueOf(br.readLine());
		int[][] map = new int [N][N];
		
		int max = 0;
		for(int i=0; i<N; i++) {
			String[] line = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.valueOf(line[j]);
				max = Math.max(max, map[i][j]);
			}
		}
		
//		System.out.println(max);
//		for(int i=0; i<N; i++) {
//			for(int a:map[i]) {
//				System.out.print(a+ " ");
//			}
//			System.out.println();
//		}
		
		
		boolean[][] visit = new boolean[N][N];
		int[] count = new int[max];
		
		for(int hight=0; hight<max; hight ++) {
			visit = resetVisit(map);
			LinkedList<MyPosition> stack = new LinkedList<>();
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					
					if(!visit[i][j] && map[i][j]>hight) {
						
					MyPosition position = new MyPosition(i,j); 
					stack.addLast(position);
					
					while(!stack.isEmpty()) {
							MyPosition prs = stack.removeLast();
							visit[prs.x][prs.y] = true;
							for(int dir=0; dir<4; dir++) {
								int nx = prs.x + dx[dir];
								int ny = prs.y + dy[dir];
								MyPosition nxt = new MyPosition(nx,ny);
								if(nx<0 || nx >= N || ny<0 || ny >= N) continue;
								if(visit[nx][ny] || map[nx][ny] <= hight) continue;
								stack.addLast(nxt);
	//							System.out.println(1);
								}
	//						System.out.println(2);
						}
					count[hight] += 1;
					}
				}
			}
		}
		int result = Arrays.stream(count).max().getAsInt();
		System.out.println(result);
		
		
		
		
		
	}
	
	public static boolean[][] resetVisit(int[][] map) {
		int N = map.length;
		boolean[][] checkMap = new boolean[N][N];
		
		
		return checkMap;
	}
}

class MyPosition{
	
	int x;
	int y;
	public MyPosition() {
		
	}
	
	public MyPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}
