package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.valueOf(br.readLine());
		
		
		int[] facto = new int[13];
		
		facto[0] = 1;
		facto[1] = 1;
		
		for(int i=2; i<13; i++) {
			facto[i] = facto[i-1] * i;
		}
		
		System.out.println(facto[num]);
	}
}
