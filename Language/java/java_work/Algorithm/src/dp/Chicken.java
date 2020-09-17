package dp;

import java.util.ArrayList;
import java.util.Scanner;

public class Chicken {

	static int[][] chickenLength;
	static boolean[] useShop;

	public static void main(String[] args) {

		int N = 0;
		int M = 0;

		Scanner sc = new Scanner(System.in);

		String NandM = sc.nextLine();
		N = Integer.parseInt(NandM.split(" ")[0]);
		M = Integer.parseInt(NandM.split(" ")[1]);

		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String line = sc.nextLine();
			String[] num = line.split(" ");
			for (int j = 0; j < num.length; j++) {
				map[i][j] = Integer.parseInt(num[j]);
			}

		}
		int result = getMinimumChicken(N, M, map);
		System.out.println(ans);
	}

	static int getMinimumChicken(int N, int M, int[][] map) {

		ArrayList<Position> homes = new ArrayList<Position>();
		ArrayList<Position> shops = new ArrayList<Position>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					homes.add(new Position(i, j));
				} else if (map[i][j] == 2) {
					shops.add(new Position(i, j));
				}
			}
		}
		int[] dpShop = new int[shops.size()];
		useShop = new boolean[shops.size()];
		int max = 987654321;
		for (int i = 0; i < dpShop.length; i++) {
			dpShop[i] = max;
		}
//		System.out.println("shops: " + shops);
//		System.out.println("homes: " + homes);

		// 각 shop에 대한 home의 치킨거리배열
		chickenLength = new int[homes.size()][shops.size()];
		for (int i = 0; i < homes.size(); i++) {
			for (int j = 0; j < shops.size(); j++) {
				chickenLength[i][j] = getDistance(homes.get(i), shops.get(j));
			}
		}
//		for(int[] i:chickenLength) {
//			for(int j:i) {
//				System.out.print(j+" ");
//			}
//			System.out.println();
//		}
		int sum = 0;
		// M 개의 치킨집을 고르는 경우의 수 조합 구하기
		dfs(0, 0, M);
		
		return ans;
	}

	static int ans = 987654321;

	private static void dfs(int cur_num, int cur_cnt, int M) {
		
		if (cur_cnt == M) {
			int sum = 0;
//			System.out.println(Arrays.toString(useShop));
			for (int i = 0; i < chickenLength.length; i++) {
				int min = 987654321;
				for (int j = 0; j < chickenLength[i].length; j++) {
					if (useShop[j]) {
						min = Math.min(min, chickenLength[i][j]);
					}
				}
//				System.out.println(min);
				sum += min;
//				System.out.println("--------");
			}
//			System.out.println("sum:"+sum);
			ans = Math.min(ans, sum);
			return;
		}

		if (cur_num == useShop.length)
			return;

		useShop[cur_num] = true;
		dfs(cur_num + 1, cur_cnt + 1, M);

		useShop[cur_num] = false;
		dfs(cur_num + 1, cur_cnt, M);

	}

	private static int getDistance(Position home, Position shop) {

		int result = Math.abs(home.x - shop.x) + Math.abs(home.y - shop.y);
		return result;
	}

}

class Position {
	int x;
	int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "x:" + this.x + " y:" + this.y;
	}

}
