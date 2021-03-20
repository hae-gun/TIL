package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SnakeGame {
	
	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Deque<Position> snakePosDeq = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] map;
		
		
		
		// 맵정보 받기
		int size = Integer.valueOf(br.readLine());
		map = new int[size][size];
		
		int appleCount = Integer.valueOf(br.readLine());
		for(int i=0; i<appleCount; i++) {
			String[] position = br.readLine().split(" ");
			int x = Integer.valueOf(position[0]);
			int y = Integer.valueOf(position[1]);
			map[x][y] = 2;
		}
		
		// 움직임 정보 받기. 
		int movingCount = Integer.valueOf(br.readLine());
		
		Deque<MoveTime> timeQ = new LinkedList<MoveTime>();
		for(int i=0; i<movingCount; i++) {
			String[] position = br.readLine().split(" ");
			timeQ.add(new MoveTime(Integer.valueOf(position[0]), position[1]));
		}
		
		
		
		
		
		// 뱀 초기 위치 (0,0)
		snakePosDeq.add(new Position(0,0));
		map[0][0] = 1;
		int dir = 0;
		int time = 0;
		
		while(true) {
			Position headPos = snakePosDeq.getFirst();
			System.out.println(time);
			
			Position nextPos = new Position(headPos.dx + dx[dir], headPos.dy + dy[dir]);
//			System.out.println(nextPos.dx + " " + nextPos.dy);
			
			if(nextPos.dx>=0 && nextPos.dx<map.length && nextPos.dy>=0 && nextPos.dy<map.length) { // 맵 안일때
				
				if(map[nextPos.dx][nextPos.dy] == 1){ // 뱀일때
					System.out.println("crush>>"+(time+1));
					break;
					
				}else if(map[nextPos.dx][nextPos.dy] == 2) { // 사과인경우
					snakePosDeq.addFirst(nextPos);
					map[nextPos.dx][nextPos.dy] = 1;
				}else {// 빈공간인경우 
					snakePosDeq.addFirst(nextPos);
					map[nextPos.dx][nextPos.dy] = 1;
					
					Position tail = snakePosDeq.removeLast();
					map[tail.dx][tail.dy] = 0;
//					System.out.println(tail.dx + " " + tail.dy);
				}
			}else { //맵 밖일때
				System.out.println("out of map>>"+(time+1));
				break;
			}
//			System.out.println(nextPos);
			System.out.println("#################################");
			for(int i=0; i<size; i++) {
				System.out.println(Arrays.toString(map[i]));
			}
			System.out.println("#################################");
			time++;
			
			
			// 방향체크
			if(!timeQ.isEmpty()) {
				if(time == timeQ.getFirst().time) {
					MoveTime mv = timeQ.removeFirst();
					if("L".equals(mv.dir)) dir = (dir+1) %4;
					if("D".equals(mv.dir)) dir = (dir+3) %4;
				}
			}
			
		}
		
		
		
		
		
		
	}
}

class MoveTime{
	int time;
	String dir;
	
	public MoveTime(int time, String dir) {
		this.time = time;
		this.dir = dir;
	}
	
}
class Position{
	int dx;
	int dy;
	
	public Position(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}

	@Override
	public String toString() {
		return "Position [dx=" + dx + ", dy=" + dy + "]";
	}
	
	
}



