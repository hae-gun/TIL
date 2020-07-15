package ProgrammersLevel2;

public class StickCutting {

	public static void main(String[] args) {
		String s = "()(((()())(())()))(())";
		
		System.out.println(solution(s));
		
	}
	public static int solution(String arrangement) {
		String S = arrangement.replace("()", "0");
		int stickCount = 0;
		int answer = 0;
		for(char s : S.toCharArray()) {
			if(s=='(') {
				stickCount++;
			}else if(s==')') {
				stickCount--;
				answer+=1;
			}else if(s=='0') {
				answer += stickCount;
			}
		}
		System.out.println(S);
        return answer;
    }

}
