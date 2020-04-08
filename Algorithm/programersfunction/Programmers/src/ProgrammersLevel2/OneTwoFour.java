package ProgrammersLevel2;

public class OneTwoFour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(solution(9));
	}
	
	
	
	public static String solution(int n) {
	      String answer = "";
	      
	      
	      do{
	    	answer += n%3;
	    	n/=3;  
	    	  
	      }while(n!=0);
	      
	      StringBuffer sb = new StringBuffer();
	      sb.append(answer);
	      answer = sb.reverse().toString();
	      answer.replaceAll("0", "4")
	      answer.replaceAll("2", "4");
	      return answer;
	  }
	
}
