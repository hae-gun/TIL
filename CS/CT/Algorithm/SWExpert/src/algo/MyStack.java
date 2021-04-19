package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MyStack {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.valueOf(br.readLine());
		String[] cmd;
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<count; i++) {
			
			cmd = br.readLine().split(" ");
			mode(stack, cmd);
			
			
		}
		
	}

	private static void mode(Stack<Integer> stack, String[] cmd) {
		String comand = cmd[0];
		int num = 0;
		if(cmd.length > 1) {
			num = Integer.valueOf(cmd[1]);
		}
		switch (comand) {
		case "push":
			stack.add(num);
			break;
		case "pop":
			if(!stack.isEmpty())
				System.out.println(stack.pop());
			else
				System.out.println(-1);
			break;
		case "size":
			System.out.println(stack.size());
			break;
		case "empty":
			if(stack.isEmpty())
				System.out.println(1);
			else
				System.out.println(0);
			break;
		case "top":
			if(stack.isEmpty())
				System.out.println(-1);
			else
				System.out.println(stack.peek());
			break;
		}
//		System.out.println(stack);
		
	}
	
	
}
