package array;

import java.util.Scanner;

public class Arr07 {
	public static void main(String[] args) {
		String[][] words = {{"chair", "의자"},
				{"computer","컴퓨터"},
				{"friend", "친구"}};
		
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<words.length; i++) {
			System.out.printf("Q%d. %s의 뜻은?", i+1, words[i][0]);
			
			String answer = sc.nextLine();
			if(answer.equals(words[i][1])) {
				System.out.println("정답입니다!");
			}else {
				System.out.printf("오답입니다. 정답은 %s입니다.\n", words[i][1]);
			}
		}
	
	}
}
