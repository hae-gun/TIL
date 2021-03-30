package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Virus {
	
	
	
	static boolean[][] visit; 
	
	
	static LinkedList<VirusPosition> virusPosition = new LinkedList<>();
	static int virusCount = 987654321;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		List<Integer> NM = readLine(br," ");
		
		
		int N = NM.get(0);
		int M = NM.get(0);
		
		int[][] map = new int[N][M];
		visit = new boolean[N][M];
		
		
		int safe = -3;
		
		for(int i=0; i<N; i++) {
			List<Integer> line = readLine(br," ");
			for(int j=0; j<M; j++) {
				map[i][j] = line.get(j);
				if(map[i][j] == 2) {
					virusPosition.addLast(new VirusPosition(i,j));
				}
				if(map[i][j] == 1) safe++;
			}
		}
		
		
		dfsWall(map,0,0,0,virusPosition);
//		for(int[] mapLine:map)
//			System.out.println(Arrays.toString(mapLine));
		
		
		System.out.println(virusCount);
		
		
	}
	
	
	public static void dfsWall(int[][] map,int depth,int x,int y,LinkedList<VirusPosition> vp) {
		if(depth == 2) {
			int[][] tmp = Arrays.copyOf(map,map.length);
			int safe  = 0;
			while(!vp.isEmpty()) {
				VirusPosition v = vp.removeLast();
				safe += dfsVirus(tmp,v.x,v.y);
			}
			virusCount = Math.min(virusCount, safe);
		}
		for(int i=x; i<map.length; i++) {
			for(int j=y; j<map[i].length; j++) {
				if(map[i][j]==0) {
					map[i][j] = 1;
					dfsWall(map,depth+1,i,j,vp);
					map[i][j] = 0;
				}
			}
		}
		
//		for(int[] mapLine:map)
//			System.out.println(Arrays.toString(mapLine));
	}
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	private static int dfsVirus(int[][] map,int x, int y) {
		int res = 1;
		
		visit[x][y] = true;
		
		for(int dir=0; dir<4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			if(nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length ) continue;
			if(visit[nx][ny] || map[nx][ny] == 1) continue;
			res += dfsVirus(map,nx,ny);
		}
		
		
		
		return res;
		
		
	}


	public static List<Integer> readLine(BufferedReader br,String delimeter){
		
		try {
			return Arrays.asList(br.readLine().split(delimeter))
					.stream().map(Integer::parseInt)
					.collect(Collectors.toList());
		} catch (IOException e) {
			return new ArrayList<Integer>();
		}
	}
	
}
class VirusPosition{
	int x;int y;

	public VirusPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}