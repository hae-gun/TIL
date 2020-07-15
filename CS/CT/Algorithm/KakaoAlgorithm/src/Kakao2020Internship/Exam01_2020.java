package Kakao2020Internship;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam01_2020 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] numberPatternS = br.readLine().split(", ");
		int length = numberPatternS.length;
		int[] numbers = new int[length];
		for (int i = 0; i < length; i++) {
			numbers[i] = Integer.valueOf(numberPatternS[i]);
		}
		String hand = br.readLine();
		String result = solution(numbers, hand);
		System.out.println(result);
	}

	public static String solution(int[] numbers, String hand) {

		String answer = "";
//	        char[][] map = {{'7','8','9'},{'4','5','6'},{'1','2','3'},{'*','0','#'}};
		String[] numMap = { "1,3", "0,0", "1,0", "2,0", "0,1", "1,1", "2,1", "0,2", "1,2", "2,2", };

		StringBuilder result = new StringBuilder();

		hand lefthand = new hand(0, 3, "left");
		hand righthand = new hand(2, 3, "right");

		for (int i = 0; i < numbers.length; i++) {
			String pressBtn = numMap[numbers[i]];
			int xPos = Integer.valueOf(pressBtn.split(",")[1]);
			int yPos = Integer.valueOf(pressBtn.split(",")[0]);

			if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
				result.append("L");
				lefthand.x = xPos;
				lefthand.y = yPos;
			} else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
				result.append("R");
				righthand.x = xPos;
				righthand.y = yPos;
			} else {

				int toLeftLength = Math.abs(lefthand.x - xPos) + Math.abs(lefthand.y - yPos);
				int toRightLength = Math.abs(righthand.x - xPos) + Math.abs(righthand.y - yPos);
				if (toLeftLength < toRightLength) {
					result.append("L");
					lefthand.x = xPos;
					lefthand.y = yPos;
				} else if (toLeftLength > toRightLength) {
					result.append("R");
					righthand.x = xPos;
					righthand.y = yPos;
				} else {
					if ("right".equals(hand)) {
						result.append("R");
						righthand.x = xPos;
						righthand.y = yPos;
					} else {
						result.append("L");
						lefthand.x = xPos;
						lefthand.y = yPos;
					}

				}
			}

//			System.out.println(righthand.toString());
//			System.out.println(lefthand.toString());
//			System.out.println("---------------");
		}
		answer = result.toString();

		return answer;
	}

}

class hand {
	int x;
	int y;
	String hand;

	hand(int x, int y, String hand) {
		this.x = x;
		this.y = y;
		this.hand = hand;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "hand: " + hand + " x: " + x + " y: " + y;
	}
}