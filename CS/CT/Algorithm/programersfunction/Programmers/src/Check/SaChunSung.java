package Check;

import java.util.Date;
import java.util.HashMap;

public class SaChunSung {

	public static void main(String[] args) {

	}

}

class Solution {
	public int solution(String[] lines) {
		int answer = 0;
		HashMap<String, String> mymap = new HashMap<>();

		for (String S : lines) {

			mymap.put(S.split(" ")[1], S.split(" ")[2]);

		}
		
		
		
		
		
		return answer;
	}
}