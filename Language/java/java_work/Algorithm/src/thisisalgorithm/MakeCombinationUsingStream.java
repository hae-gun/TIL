package thisisalgorithm;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.reducing;

import java.util.Arrays;


public class MakeCombinationUsingStream {
	public static void main(String[] args) {
		
		int[] set = {1,2,3,4,5};
		String[][] s = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		
		int i = Arrays.stream(s)
			.collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
			.values().stream().collect(reducing(1L, (x, y) -> x * (y + 1))).intValue();
	       
	        System.out.println(i);
//		System.out.println(list);
									
		
	}
	
}
