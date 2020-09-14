package cospro;

import java.util.Scanner;

public class Num_3 {

	public static void main(String[] args) {

		int[] dx = { 1, 2, 2, 1, -1, -2, -2, -1 };
		int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };
		
		int[][] map = new int[8][8];
		
		
		Scanner sc = new Scanner(System.in);
		
		String pos = sc.nextLine();
		
		int x = Integer.valueOf(pos.charAt(0) - 'A');
		int y = Integer.valueOf(pos.charAt(1) - '1');
		System.out.printf("%d , %d\n",x,y);
		
		int answer = 0;
		
		for(int i=0; i<8; i++) {
			
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(nx >=0 && nx < 8 && ny >=0 && ny < 8) {
				answer++;
			}
			
			
		}
		System.out.println(answer);
		

	}
}
