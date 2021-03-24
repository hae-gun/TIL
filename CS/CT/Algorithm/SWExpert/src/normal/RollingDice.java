package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class RollingDice {

	
	
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	static String[] direction = {"→", "←","↑","↓"};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N,M,x,y,movingCount = 0;
		
		String[] input = br.readLine().split(" ");
		
		 N = Integer.valueOf(input[0]);
		 M = Integer.valueOf(input[1]);
		 x = Integer.valueOf(input[2]);
		 y = Integer.valueOf(input[3]);
		 movingCount = Integer.valueOf(input[4]);
		
		 int[][] map = new int[N][M];
		 
		 
		 // 맵 설정
		for(int i=0; i<N; i++) {
			String[] line = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.valueOf(line[j]);
			}
		}
		
		String[] tmp = br.readLine().split(" ");
		Queue<Integer> moving = new LinkedList<Integer>();
		// 주사위 움직임 값 설정 
		for(int i=0; i<movingCount; i++) {
			moving.add(Integer.valueOf(tmp[i]));
		}
		
		
		
		Dice dice = new Dice();
		// 움직임이 끝날 때 까지
		
		while(!moving.isEmpty()) {
			int dir = moving.poll();
		
			int nx = x + dx[dir-1];
			int ny = y + dy[dir-1];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
				continue;
			}
			
			
			
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<M; j++) {
//					if(j==y &&i==x) {
//						System.out.print(">"+map[i][j]+" ");
//					}else {
//						System.out.print(map[i][j]+" ");
//					}
//				}
//				System.out.println();
//			}
//			System.out.println("##############");
//			System.out.println("  " + dice.back + "  ");
//			System.out.println(dice.left + " " + dice.top + " "+dice.right);
//			System.out.println("  " + dice.front + "  ");
//			System.out.println("  " + dice.bottom + "  ");
//			System.out.println("###### "+direction[dir-1]+" ######");
			x = nx;
			y = ny;
			dice = dice.turn(dir);
			
			if(map[nx][ny] == 0) {
				map[nx][ny] = dice.bottom;
			}else {
//				int temp = dice.bottom;
				dice.bottom = map[nx][ny];
				map[nx][ny] = 0;
			}
			
			System.out.println(dice.top);
		}
		
	}
	
}



class Dice{
	int top=0;
	int bottom=0;
	int right=0;
	int left=0;
	int front=0;
	int back=0;
	
	
	public Dice turn(int dir) {
		
		Dice result = new Dice();
		switch (dir) {
		case 1:
			result = this.turnEast();
			break;
		case 2:
			result = this.turnWest();
			break;
		case 3:
			result = this.turnNorth();
			break;
		case 4:
			result = this.turnSouth();
			break;
		default:
			break;
		}
		
		return result;
		
	}
	
	
	
	public Dice turnEast() {
		Dice nextDice = new Dice();
		
		nextDice.back = this.back;
		nextDice.front = this.front;
		
		nextDice.top = this.left;
		nextDice.right = this.top;
		nextDice.bottom = this.right;
		nextDice.left = this.bottom;
		
		
		return nextDice;
	}
	public Dice turnWest() {
		Dice nextDice = new Dice();
		
		nextDice.back = this.back;
		nextDice.front = this.front;
		
		nextDice.top = this.right;
		nextDice.right = this.bottom;
		nextDice.bottom = this.left;
		nextDice.left = this.top;
		
		
		return nextDice;
	}
	public Dice turnNorth() {
		Dice nextDice = new Dice();
		
		nextDice.left = this.left;
		nextDice.right = this.right;
		
		nextDice.top = this.front;
		nextDice.front = this.bottom;
		nextDice.bottom = this.back;
		nextDice.back = this.top;
		
		
		return nextDice;
	}
	public Dice turnSouth() {
		Dice nextDice = new Dice();
		
		nextDice.left = this.left;
		nextDice.right = this.right;
		
		nextDice.top = this.back;
		nextDice.front = this.top;
		nextDice.bottom = this.front;
		nextDice.back = this.bottom;
		
		
		return nextDice;
	}



	@Override
	public String toString() {
		return "Dice [top=" + top + ", bottom=" + bottom + ", right=" + right + ", left=" + left + ", front=" + front
				+ ", back=" + back + "]";
	}
	
	
	
	
	
}
