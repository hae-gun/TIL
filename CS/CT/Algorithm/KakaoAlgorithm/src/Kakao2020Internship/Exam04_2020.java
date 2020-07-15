package Kakao2020Internship;

import java.util.LinkedList;

class Solution {

	int[] dx = { +1, 0, -1, 0 };
	int[] dy = { 0, +1, 0, -1 };

	class Car {
		int x = 0;
		int y = 0;

	}

	public int solution(int[][] board) {
		int answer = 0;
		Car car = new Car();
		int price = 0;
		LinkedList<Car> stack = new LinkedList<Car>();
		stack.addLast(car);
		while (!stack.isEmpty()) {
			Car nextCar = stack.pop();
			for (int i = 0; i < 4; i++) {
				if (nextCar.x + dx[i] >= 0 && nextCar.x + dx[i] < board[0].length && nextCar.y + dy[i] >= 0
						&& nextCar.y + dy[i] < board.length) {
					if (board[nextCar.y + dy[i]][nextCar.x + dx[i]] != 1) {
						price += 100;
						nextCar.x += dx[i];
						nextCar.y += dy[i];
						stack.addLast(nextCar);
					} else {
						price += 400;						
					}
				}

			}

		}
			answer = price;
			return answer;
			

	}
}

public class Exam04_2020 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String map = "{{0,0,0},{0,0,0},{0,0,0}}";
		int[][] board;
		String[] line = map.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
		int l1 = line.length;
		int l2 = line[0].split(",").length;
		board = new int[l1][l2];

		System.out.println(s.solution(board));
	}
}
