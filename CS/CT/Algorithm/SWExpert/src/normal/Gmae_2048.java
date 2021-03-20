package normal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Gmae_2048 {
	
	static int max = 0;
	static char[] mdir = {'U','D','R','L'};
	static int size=0;
	public static void main(String[] args) {
		
		
		int[][] board = null;
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 보드 초기화과정
		try {
			size = Integer.valueOf(br.readLine());
			board = new int[size][size];
			
			for(int i=0; i<size; i++) {
				String lineNumber = br.readLine();
				String[] numbers = lineNumber.split(" ");
				for(int j=0; j<size; j++) {
					board[i][j] = Integer.valueOf(numbers[j]);
					if(board[i][j] > max) max = board[i][j];
				}
			}
		} catch (Exception e) {
		}
//		for(int i=0; i<size; i++)
//			System.out.println(Arrays.toString(board[i]));
		for(int i=0; i<4;i++) {
			game(board,0,mdir[i]);
		}
		System.out.println(max);
		
		
	}


	private static void game(int[][] board, int count, char c) {
		if(count==5) return;
		int size = board.length;
		int[][] nextBoard = new int[size][size];
		Stack<Integer> stack = new Stack<>();
//		System.out.println("##############"+c+"#######"+count+"######");
		
//		for(int i=0; i<size; i++)
//		System.out.println(Arrays.toString(board[i]));
		boolean flag = true;
			switch(c) {
			case 'R':
				for(int i=0; i<size; i++) {
					for(int j=size-1; j>=0; j--) {
						if(board[i][j]!=0) {
							if(stack.size()==0) stack.push(board[i][j]);
							else {
								if(stack.peek()==board[i][j] && flag) {
									stack.add(stack.pop()+board[i][j]);
									flag=false;
									
									if(stack.peek()>max) max = stack.peek();
									continue;
								}else {
									stack.add(board[i][j]);
								}
							}
							flag = true;
						}
					}
					
					while(!stack.isEmpty()) {
						int idx = size - stack.size();
						nextBoard[i][idx] = stack.pop();
						
					}
					stack.clear();
				}
				break;
			case 'L':
				for(int i=0; i<size; i++) {
					for(int j=0; j<size; j++) {
						if(board[i][j]!=0) {
							if(stack.size()==0) stack.push(board[i][j]);
							else {
								if(stack.peek()==board[i][j] && flag) {
									stack.add(stack.pop()+board[i][j]);
									flag=false;
									
									if(stack.peek()>max) max = stack.peek();
									continue;
								}else {
									stack.add(board[i][j]);
								}
							}
							flag = true;
						}
					}
					while(!stack.isEmpty()) {
						int idx = stack.size()-1;
						nextBoard[i][idx] = stack.pop();
						
					}
					stack.clear();
				}
				break;
			case 'U':
				for(int j=0; j<size; j++) {
					for(int i=0; i<size; i++) {
						if(board[i][j]!=0) {
							if(stack.size()==0) stack.push(board[i][j]);
							else {
								if(stack.peek()==board[i][j] && flag) {
									stack.add(stack.pop()+board[i][j]);
									flag=false;
									
									if(stack.peek()>max) max = stack.peek();
									continue;
								}else {
									stack.add(board[i][j]);
								}
							}
							flag = true;
						}
					}
					while(!stack.isEmpty()) {
						int idx = stack.size()-1;
						nextBoard[idx][j] = stack.pop();
					}
					stack.clear();
					
				}
				break;
			case 'D':
				for(int j=0; j<size; j++) {
					for(int i=size-1; i>=0; i--) {
						if(board[i][j]!=0) {
							if(stack.size()==0) stack.push(board[i][j]);
							else {
								if(stack.peek()==board[i][j] && flag) {
									stack.add(stack.pop()+board[i][j]);
									flag=false;
									
									if(stack.peek()>max) max = stack.peek();
									continue;
								}else {
									stack.add(board[i][j]);
								}
							}
							flag = true;
						}
					
						
					}
					while(!stack.isEmpty()) {
						int idx = size - stack.size();
						nextBoard[idx][j] = stack.pop();
					}
					stack.clear();
				}
				break;
			}
//			for(int i=0; i<size; i++)
//			System.out.println(Arrays.toString(nextBoard[i]));
//			System.out.println("#############################");
		for(int i=0; i<4; i++) {
			game(nextBoard,count+1,mdir[i]);
		}
	}
}