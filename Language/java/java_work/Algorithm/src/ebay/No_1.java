package ebay;

public class No_1 {
	public static void main(String[] args) {

		int[][] simulation_data =
			{ { 0, 3 }, { 2, 5 }, { 4, 2 }, { 5, 3 } };
//				{ { 2, 3 }, { 5, 4 }, { 6, 3 }, { 7, 4 } };
		System.out.println(solution(2, simulation_data));

	}

	static int solution(int N, int[][] simulation_data) {
		int answer = 0;

		User[] counter = new User[N];

		for (int i = 0; i < simulation_data.length; i++) {
			int comeTime = simulation_data[i][0];
			int processTime = simulation_data[i][1];
			boolean flag = false;

			for (int j = 0; j < counter.length; j++) {

				if (counter[j] == null) {
					counter[j] = new User(comeTime, processTime);
					flag = true;
					break;
				}
			}
			if (flag) {
				continue;
			}
			int min = 987654321;
			int index = 0;
			for (int j = 0; j < counter.length; j++) {
				int time = counter[j].comeTime + counter[j].processTime;
				if (min > time) {
					min = time;
					index = j;
				}

			}

			if (min > comeTime) {
				while (min != comeTime) {
					comeTime++;
					answer++;
				}
			}

			counter[index] = new User(comeTime, processTime);

		}

		return answer;

	}

}

class User {
	int comeTime;
	int processTime;

	public User() {
	}

	public User(int comeTime, int processTime) {
		this.comeTime = comeTime;
		this.processTime = processTime;
	}

	public int getEndTime() {
		return comeTime + processTime;
	}

	@Override
	public String toString() {
		return comeTime + ":" + processTime;
	}

}
