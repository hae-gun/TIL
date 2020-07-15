package test;

import java.util.LinkedList;

public class TestNo01 {

	public static void main(String[] args) {

		Solution s = new Solution();
		s.solution("line [plus]");

	}

}

class Solution {
	public int solution(String inputString) {
		int answer = 0;
		LinkedList<String> queue = new LinkedList<String>();
		char[] word = inputString.toCharArray();
		int length = 0;
		for (char check : word) {
			if (check == '<' || check == '>' || check == '{' || check == '}' || check == '[' || check == ']'
					|| check == '(' || check == ')') {
				queue.add(String.valueOf(check));
				length++;
			}
		}
		System.out.println(queue);
		String front, back;
		for (int i = 0; i < length; i++) {
			front = queue.get(i);
			for (int j = 0; j < length; j++) {
				back = queue.get(j);
				
				if (!isOpen(front) && (j > i) && back.equals(CheckString(front))) {
					return answer = -1;
				}
				if (!queue.contains(CheckString(front))) {
					return answer = -1;
				}else if (isOpen(front) && back.equals(CheckString(front))) {
					answer++;
				}
				
			}
		}
		System.out.println(answer);
		return answer;

	}

	String CheckString(String s) {
		String result = "";
		switch (s) {
		case "<":
			result = ">";
			break;
		case "{":
			result = "}";
			break;
		case "[":
			result = "]";
			break;
		case "(":
			result = ")";

			break;
		case ">":
			result = "<";
			break;
		case "}":
			result = "{";
			break;
		case "]":
			result = "[";
			break;
		case ")":
			result = "(";

			break;

		default:
			result = null;
			break;
		}
		return result;
	}

	Boolean isOpen(String s) {
		Boolean result = false;
		switch (s) {
		case "<":
		case "{":
		case "[":
		case "(":
			result = true;
			break;
		case ">":
		case "}":
		case "]":
		case ")":
			result = false;
			break;
		default:
			break;
		}

		return result;
	}

}
