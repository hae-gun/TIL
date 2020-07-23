package cs03_for;

public class For10 {
	public static void main(String[] args) {
		System.out.println("구구단");

		for (int i = 2; i < 10; i++) {
			System.out.print(i + "단\t");
		}
		
		System.out.println();
		
		for (int i = 1; i < 10; i++) {
			for (int j = 2; j < 10; j++) {
				System.out.printf("%d*%d=%2d  ", j, i, i * j);
			}
			System.out.println();
		}

		for (int i = 2; i < 10; i++) {
			System.out.print(i + "단: ");
			for (int j = 1; j < 10; j++) {
				if (j == 9)
					System.out.printf("%d*%d=%2d", i, j, i * j);
				else
					System.out.printf("%d*%d=%2d, ", i, j, i * j);
			}
			System.out.println();
		}
	}
}
