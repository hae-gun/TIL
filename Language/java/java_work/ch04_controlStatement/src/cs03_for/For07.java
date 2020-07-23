package cs03_for;

/*
 *****
 ****
 ***
 **
 * 
 */

public class For07 {
	public static void main(String[] args) {
		char ast = '*';

		for (int i = 5; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print(ast);
			}
			System.out.println();
		}
		
	}
}
