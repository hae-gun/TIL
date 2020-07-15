package kakaotest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Example04Room {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long k = Integer.valueOf(br.readLine());
		String[] set = br.readLine().split(",");
//		System.out.println(k);
		long[] room_number = new long[set.length];
		for(int i=0; i<set.length; i++) {
			room_number[i] = Integer.valueOf(set[i]);
		}
		
//		for(long t : room_number) {
//			System.out.println(t);
//		}
		
		
		
		
		long[] result = solution(k,room_number);
		for(long t:result) {
			System.out.println(t);
		}
		
	}
	
	public static long[] solution(long k, long[] room_number) {
		
		boolean set[] = new boolean[200000];
		
//		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		String[] result = new String[room_number.length];
		
		
		for(long i=0; i<room_number.length;i++) {
			if(!set[(int)room_number[(int)i]]) {
				set[(int)room_number[(int)i]] = true;
				result[(int)i] = String.valueOf(room_number[(int)i]);
			}else {
				for(int j =1; j<set.length; j++) {
					if(!set[j]) {
						set[j]=true;
						result[(int)i] = String.valueOf(j);
						break;
					}
				}
			}
		}
		
		long[] answer = new long[result.length];
		
		for(int i=0; i<result.length; i++) {
			answer[i] = Long.valueOf(result[i]);
		}
		
		
		
        return answer;
    }

}
