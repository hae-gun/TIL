package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Tomato {

	public static void main(String[] args) throws IOException {
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nm = br.readLine().split(" ");
		int n = Integer.valueOf(nm[0]);
		int m = Integer.valueOf(nm[1]);
		int[][] map = new int[m][n];
		int[][] next = new int[m][n];

		for (int y = 0; y < m; y++) {
			String[] set = br.readLine().split(" ");
			for (int x = 0; x < n; x++) {
				map[y][x] = Integer.valueOf(set[x]);

			}
		}

		int ret = 0;

		while (true) {
			
			for (int y = 0; y < m; y++) {
				for (int x = 0; x < n; x++) {
					

					if (map[y][x] == -1 || map[y][x] == 1) {
						next[y][x] = map[y][x];
					}

					if (map[y][x] == 1) {
						for (int dir = 0; dir < 4; dir++) {
							if ((x + dx[dir] < n && x + dx[dir] >= 0 && y + dy[dir] < m && y + dy[dir] >= 0)) {
								if ((map[y + dy[dir]][x + dx[dir]] == 0)) {
									next[y + dy[dir]][x + dx[dir]] = 1;
								}
							}

						}

					}

				}
			}

			boolean check = true;

			for (int y = 0; y < m; y++) {
				for (int x = 0; x < n; x++) {
					if (map[y][x] != next[y][x]) {
						check = false;
						break;
					}
					if (!check) {
						break;
					}
				}
			}
			
//			for (int[] a : map) {
//				for (int b : a) {
//					System.out.print(b);
//				}
//				System.out.println();
//			}

			if (check) {
				break;
			}
			ret++;
			for (int y = 0; y < m; y++) {
				for (int x = 0; x < n; x++) {
					map[y][x] = next[y][x];
				}
			}

		}

		for (int y = 0; y < m; y++) {
			for (int x = 0; x < n; x++) {
				if (map[y][x] == 0) {
					ret = -1;
				}
			}
		}

		System.out.println(ret);
	}

}
