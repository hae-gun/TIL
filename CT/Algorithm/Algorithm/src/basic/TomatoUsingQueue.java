package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Dot {
	int x;
	int y;

	Dot(int y, int x) {
		this.x = x;
		this.y = y;
	}
}

public class TomatoUsingQueue {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		int n = Integer.valueOf(nm[0]);
		int m = Integer.valueOf(nm[1]);
		int[][] map = new int[m][n];

		Queue<Dot> queue = new LinkedList<Dot>();
		for (int y = 0; y < m; y++) {
			String[] set = br.readLine().split(" ");
			for (int x = 0; x < n; x++) {
				map[y][x] = Integer.valueOf(set[x]);
				if (map[y][x] == 1) {
					queue.add(new Dot(y, x));
				}
			}
		}
		int ret = 0;

		BFS(map, queue, n, m);

	}

	public static void BFS(int[][] map, Queue<Dot> queue, int n, int m) {
		int ret = 0;
		while (!queue.isEmpty()) {
			Dot cur = queue.poll();

			for (int dir = 0; dir < 4; dir++) {
				int nextY = cur.y + dy[dir];
				int nextX = cur.x + dx[dir];

//				if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
//					continue;
//				}
//
//				if (map[nextY][nextX] != 0) {
//					continue;
//				}
				if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m && map[nextY][nextX] == 0) {
//					if(map[nextY][nextX] == 0)
					map[nextY][nextX] = map[cur.y][cur.x] + 1;
					queue.add(new Dot(nextY, nextX));
				}

			}

		}
//				for (int[] a : map) {
//					for (int b : a) {
//
//						System.out.print(b + " ");
//					}
//					System.out.println();
//
//				}
//				System.out.println("----------");

		for (

				int y = 0; y < m; y++) {
			for (int x = 0; x < n; x++) {
				if (map[y][x] == 0) {
					System.out.println(-1);
					return;
				}
				ret = Math.max(map[y][x], ret);
			}
		}
		if (ret != 0) {
			ret -= 1;
		}
		System.out.println(ret);
	}

}
