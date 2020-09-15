
public class Num_6 {
	public static void main(String[] args) {

		String movement = "URDDL";

		String result = solution(movement);
		System.out.println(result);
	}

	private static String solution(String movement) {
		String result = "";

		// L R U D
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		int x = 0, y = 0;

		char[] cSet = movement.toCharArray();

		for (char c : cSet) {
			int idx = findIndex(c);
			x += dx[idx];
			y += dy[idx];
		}

		result = "[" + x + "," + y + "]";

		return result;
	}

	static int findIndex(char a) {
		int idx = 0;
		char[] move = { 'L', 'R', 'U', 'D' };

		for (int i = 0; i < move.length; i++) {
			if (a == move[i]) {
				idx = i;
				break;
			}
		}

		return idx;
	}
}
