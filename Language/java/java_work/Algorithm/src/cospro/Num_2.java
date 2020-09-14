package cospro;

import java.util.LinkedList;

public class Num_2 {
	public static void main(String[] args) {

		int n = 10;

		int[][] map = new int[n][n];

		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };

		int x = 0;
		int y = 0;
		map[x][y] = 1;
		Point p = new Point(x, y);
		LinkedList<Point> list = new LinkedList<>();
		list.add(p);
		int idx = 0;
		int count = 0;
		while (!list.isEmpty()) {

			Point temp = list.removeFirst();
			int nx = temp.x + dx[idx];
			int ny = temp.y + dy[idx];
			// map 안벗어난 경우
			if (nx < n && nx >= 0 && ny < n && ny >= 0) {
				if (map[nx][ny] == 0) {
					map[nx][ny] = map[nx-dx[idx]][ny-dy[idx]] +1;
					list.add(new Point(nx,ny));
					count=0;
				}else {
					// 범위 안에서 다음진행방향에 이미 숫자가 들어간 경우 회전
					idx = turnRight(idx);
					list.add(temp);
					count++;
				}
				//맵을 벗어난경우 방향전환
			}else {
				idx = turnRight(idx);
				list.add(temp);
			}
			if(count >=4) {
				break;
			}
			
		}

		// 돌면서 숫자넣기

		int answer = 0;
		// 대각선 숫자 합 구하기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					answer += map[i][j];
				}
			}
		}
		for(int[] r:map) {
			for(int c:r) {
				System.out.printf("%2d ",c);
			}
			System.out.println();
		}
		System.out.println(answer);
	}
	
	
	static int turnRight(int idx) {
		idx += 1;
		if(idx>=4) idx = 0;
		return idx;
	}

}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
