package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PoorMan {
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		List<Integer> abc = Arrays.asList(br.readLine().split(" "))
								.stream().map(Integer::parseInt)
								.collect(Collectors.toList());
		
		int a = abc.get(0);
		int b = abc.get(1);
		int c = abc.get(2);
		
		List<Integer> position = Arrays.asList(br.readLine().split(" "))
				.stream().map(Integer::parseInt)
				.collect(Collectors.toList());
		
		int[][] xy = {
				{position.get(0),position.get(2)},
				{position.get(0),position.get(3)},
				{position.get(1),position.get(2)},
				{position.get(1),position.get(3)}
				};
		
		
		// ax+by+c = 0
		// y = (-ax-c)/b
		
//		int[] y = new int[2];
//		
//		y[0] = (-a*xy[0][0] - c)/b;
//		y[1] = (-a*xy[1][0] - c)/b;
//		
		String answer = "";
		
//		if((y[0] <= xy[0][1] && y[1] <= xy[2][1])||(y[0] >= xy[1][1] && y[1] >= xy[3][1])) {
//			answer = "Lucky";
//		}else {
//			answer = "Poor";
//		}
		
		int ld = a * xy[0][0] + b * xy[0][1] + c;
		int lu = a * xy[1][0] + b * xy[1][1] + c;
		int rd = a * xy[2][0] + b * xy[2][1] + c;
		int ru = a * xy[3][0] + b * xy[3][1] + c;
		
//		System.out.printf("%d %d %d %d",ld,lu,rd,ru);
		
//		int xi = -(c/a);
//		int yi = -(c/b);
		
		if(a*b <0) {
			if(lu<=0 || rd >=0) answer = "Lucky";
			else answer = "Poor";
		}else if(a*b >0) {
			if(ld>=0 || ru<=0) answer = "Lucky";
			else answer = "Poor";
		}else if(a==0) {
			if(-c/b < position.get(4) && -c/b > position.get(3) ) {
				answer = "Poor";
			}else {
				answer = "Lucky";
			}
		}else if(b==0) {
			if(-a/c > position.get(0) && -a/c < position.get(1)) answer = "Poor";
			else answer = "Lucky";
		}
		
		
		System.out.println(answer);
		
	}
}
