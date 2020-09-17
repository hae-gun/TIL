package Algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class problem_17140 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int r, c, k;
		String s = br.readLine();
		String[] num = s.split(" ");

		r = Integer.parseInt(num[0]);
		c = Integer.parseInt(num[1]);
		k = Integer.parseInt(num[2]);

		int[][] map = new int[3][3];

		for (int i = 0; i < 3; i++) {
			String tmp = br.readLine();
			String[] tt = tmp.split(" ");
			map[i][0] = Integer.parseInt(tt[0]);
			map[i][1] = Integer.parseInt(tt[1]);
			map[i][2] = Integer.parseInt(tt[2]);
		}

//		for (int[] i : map) {
//			for (int j : i) {
//				System.out.printf(j + " ");
//			}
//			System.out.println();
//		}
		mySort(map);

	}

	public static int[][] mySort(int[][] map) {

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		int max = 0;
		String[] set = new String[map.length];
		for (int i = 0; i < map.length; i++) {
			String line = "";
			for (int j = 0; j < map[i].length; j++) {
				queue.add(map[i][j]);
			}
			int prev = queue.poll();
			int count = 1;

			while (!queue.isEmpty()) {
				int cur = queue.poll();
				if (cur == prev) {
					count++;
				} else {
					line += prev + "" + count;
					count = 1;
				}
				cur = prev;

			}
			set[i] = line;
		}

		for (String s : set) {
			System.out.println(s);
		}

		return map;
	}

}
