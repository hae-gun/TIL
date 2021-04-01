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
		
		
		
		int x1 = position.get(0);
		int x2 = position.get(1);
		int y1 = position.get(2);
		int y2 = position.get(3);
		
		int xset[] = {x1,x2};
		int yset[] = {y1,y2};
		// ax+by+c=0;
		
		int[] count = new int[2];
		
		for(int x :xset) {
			for(int y:yset) {
				int r = a*x + b*y + c;
				if(r <= 0) count[0] ++;
				if(r >= 0) count[1] ++;
			}
		}
		String[] answer = {"Poor","Lucky"};
		
		if(count[0]==4 || count[1]==4) {
			System.out.println(answer[1]);
		}else {
			System.out.println(answer[0]);
		}
		
	}
}
