package cs03_for;

public class For13 {

	public static void main(String[] args) {

		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 6; j++) {
				System.out.printf("[%d, %d]", i, j);
			}
			System.out.println();
		}

		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 6; j++) {
				if (i == j) {
					System.out.printf("      ");

				} else {
					System.out.printf("[%d, %d]", i, j);
				}
			}
			System.out.println();
		}
	}
}
