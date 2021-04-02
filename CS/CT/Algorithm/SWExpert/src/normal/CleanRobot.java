package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class CleanRobot {
	
	
	
		// 0 북 1 동 2 남 3 서  
		static int[] dx = { -1, 0, 1, 0};
		static int[] dy = { 0, 1, 0, -1};
		static int count = 1;
		static int[][] map;
		
		
	// Using bfs
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		List<Integer> NM = (List<Integer>) readLine(br," ");
		
		int N = NM.get(0);
		int M = NM.get(1);
		
		map = new int[N][M];

		List<Integer> RCD = (List<Integer>)readLine(br," ");
		
		for(int i=0; i<map.length; i++) {
			map[i] = setArray(br, " ");
		}
		
		
		int R = RCD.get(0);
		int C = RCD.get(1);
		int dir = RCD.get(2);
		
		
		Cleaner robot = new Cleaner(R, C, dir);
		
		BFS(robot);
		
		
		
		
	}
	
	public static void BFS(Cleaner robot) {
		
		LinkedList<Cleaner> que = new LinkedList<>();
		
		que.add(robot);
		int count = 0;
		while(!que.isEmpty()) {
			
			Cleaner cur = que.removeFirst();
			
			if(map[cur.x][cur.y] == 0) {
				map[cur.x][cur.y] = 2;
				count++;
			}
			
			Cleaner next = new Cleaner();
			
			for(int dir = 0; dir < 4; dir++) {
				next.dir = (cur.dir + 3 - dir) %4 ;
				next.x = cur.x +  dx[ next.dir ];
				next.y = cur.y +  dy[ next.dir ];
				
				if(next.x < 0 || next.x >= map.length || next.y < 0 || next.y > map[0].length || map[next.x][next.y] != 0) continue;
				que.add(next);
				break;
			}
			
			if(que.isEmpty()) {
				next.dir = cur.dir;
				next.x = cur.x +  dx[ (next.dir + 2) % 4 ];
				next.y = cur.y +  dy[ (next.dir + 2) % 4];
				
				if(next.x < 0 || next.x >= map.length || next.y < 0 || next.y > map[0].length || map[next.x][next.y] == 1) {
					break;
				}
				que.add(next);
			}
			
			
		}
		System.out.println(count);
	}
	
	
	public static List<?> readLine(BufferedReader br, String reg) throws IOException{
		return Arrays.asList(br.readLine().split(reg))
				.stream().map(Integer::parseInt)
				.collect(Collectors.toList());
	}
	
	public static int[] setArray(BufferedReader br, String reg) throws IOException {
		List<Integer> list = (List<Integer>) readLine(br, reg);
		int[] result = new int[list.size()];
		
		for(int idx = 0; idx<list.size(); idx++) {
			result[idx] = list.get(idx);
		}
		
		return result;
	}
	
	
}


class Cleaner{
	int x,y;
	int dir;
	
	public Cleaner() {}
	
	public Cleaner(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
	
	
	
	@Override
	public String toString() {
		
		return "("+this.x+","+this.y+") DIR:: "+this.dir;
	}
}
