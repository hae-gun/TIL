package cs01_if;

public class If04 {
	public static void main(String[] args) {

		int age = 27;

		if (age > 0) {
			if (age < 15) {
				System.out.println("우유");
			} else if (age < 18) {
				System.out.println("커피");
			} else {
				System.out.println("소주");
			}

		} else {
			System.out.println("you are an angel!");
		}

	}
}
