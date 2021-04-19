package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class ParenthesisString {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.valueOf(br.readLine());
		
		for (int i=0; i<number; i++) {
			String parenthesis = br.readLine();
			check(parenthesis);
		}
		
		
	}

	private static void check(String parenthesis) {
		Stack<Character> stack =  new Stack<>();
		char[] set = parenthesis.toCharArray();
		
		for(char s : set) {
			if(s=='(') stack.add(s);
			else if(s==')' && !stack.isEmpty()) {
				char tmp = stack.peek();
				if(tmp == '(') {
					stack.pop();
				}else {
					stack.add(s);
				}
			}else {
				stack.add(s);
			}
		}
		
		if(stack.isEmpty())
			System.out.println("YES");
		else
			System.out.println("NO");
		
	}
}
