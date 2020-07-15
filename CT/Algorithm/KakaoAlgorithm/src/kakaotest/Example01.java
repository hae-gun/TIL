package kakaotest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Example01 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String boardString = br.readLine();
		String movesString = br.readLine();

		String[] s = boardString.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
		int num = s[0].split(",").length;

		String[] m = movesString.split(",");
		int moves[] = new int[m.length];

		for (int i = 0; i < m.length; i++) {
			moves[i] = Integer.valueOf(m[i]);
		}

		int board[][] = new int[s.length][num];

		for (int x = 0; x < s.length; x++) {
			for (int y = 0; y < num; y++) {
				board[y][x] = Integer.valueOf(s[y].split(",")[x]);
			}
		}

		for (int[] set : board) {
			for (int bbb : set) {
				System.out.print(bbb + " ");
			}
			System.out.println();
		}
		System.out.println("----------");

		for (int set : moves) {
			System.out.print(set + " ");
		}
		System.out.println();

		int result = solution(board, moves);
		System.out.println("답: " + result);
		
		
	}

//	{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}
//  1,5,3,5,1,2,1,4
	public static int solution(int[][] board, int[] moves) {
		int answer = 0;
		LinkedList<Integer> stack = new LinkedList<Integer>();
		for (int i = 0; i < moves.length; i++) {
			int index = moves[i] - 1;
			for (int y = 0; y < board.length; y++) {
				if (board[y][index] != 0) {
					int temp = board[y][index];
					board[y][index]=0;
					if (!stack.isEmpty() && (stack.getLast() == temp)) {
						answer += 2;
						stack.removeLast();
						break;
					} else {
					stack.addLast(temp);
					break;
					}
				}
			}
		}
//		for (Integer test : stack) {
//			System.out.println(test);
//		}
//
//		for (int[] set : board) {
//			for (int bbb : set) {
//				System.out.print(bbb + " ");
//			}
//			System.out.println();
//		}

		return answer;
	}

}
