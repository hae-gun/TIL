package test;

import java.util.LinkedList;
import java.util.Scanner;

public class Droen {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a, b, c = 0;

		int n = scan.nextInt();

		int[][] map = new int[n][n];

		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				map[y][x] = scan.nextInt();
			}
		}

//		for (int[] a : map) {
//			for (int x : a) {
//				System.out.print(x + " ");
//			}
//			System.out.println();
//		}
		SolutionDrone s = new SolutionDrone();
		System.out.println(s.solution(map));

	}
}

class SolutionDrone {
	public int solution(int[][] board) {
		int answer = 0;
		int N = board.length-1;
		int lx = 0, ly = 0, rx = 0, ry = 0;
		
		int count =0 ;
		
		
		
		LinkedList<String> queue = new LinkedList<>();
		String position = "";
		position += lx;
		position += ly;
		position += rx;
		position += ry;
		queue.addLast(position);
		// 회전 좌표.
		int[] tx = { 1, 1, -1, -1 };
		int[] ty = { -1, 1, 1, -1 };
		// 이동 좌표
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		while (!queue.isEmpty()) {
			S
			if((lx==N && ly==N)||(rx==N && ry==N)) {
				
				break;
			}
			
			
			
			
		}
		return answer;
	}
}
