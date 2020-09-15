
public class Num_5 {
	public static void main(String[] args) {

		int[] set = { 3, 1, 2, 4, 5, 1, 2, 2, 3, 4 };
		int max = 1;

		// O(N^2)
		for (int i = 0; i < set.length; i++) {
			int count = 1;
			for (int j = i; j < set.length - 1; j++) {
				if (set[j] < set[j + 1]) {
					count++;
				} else {
					break;
				}
			}
			max = Math.max(max, count);

		}
		System.out.println(max);

		// O(N)
		int dp[] = new int[set.length];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = 1;
		}

		for (int i = 1; i < set.length; i++) {
			if (set[i] > set[i - 1]) {
				dp[i] = dp[i - 1] + 1;
			}
		}
		int answer = 0;
		for (int i = 0; i < set.length; i++) {
			answer = Math.max(answer, dp[i]);
		}
		System.out.println(answer);

	}
}
