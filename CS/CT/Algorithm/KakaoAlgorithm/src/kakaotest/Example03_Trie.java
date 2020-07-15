package kakaotest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Example03_Trie {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		// input
		// user_id : "frodo", "fradi", "crodo", "abc123", "frodoc"
		// banned_id : "fr*d*", "abc1**"
		
		String[] user_id = br.readLine().replaceAll("[\"]"," ").trim().split(" ,  ");
		
		for(String id : user_id) {
			System.out.println(id);
		}
	}
	
	public static int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        return answer;
    }
}
