package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Operator {

	static int max = -987654321;
	static int min = 123456789;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int numberCount = Integer.valueOf(br.readLine());
		List<Integer> numbers = (List<Integer>) readLine(br,"i");
		// + - * /  순
		List<Integer> operator = (List<Integer>) readLine(br,"i");
		reculsive(1, numberCount, numbers.get(0), operator.get(0), operator.get(1), operator.get(2), operator.get(3), numbers);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	
	
	public static List<?> readLine(BufferedReader br,String type) throws IOException{
		List<?> list = null;
		if("S".equalsIgnoreCase(type)) {
			list = Arrays.asList(br.readLine().split(" "));
		}else if("I".equalsIgnoreCase(type)) {
			list = Arrays.asList(br.readLine().split(" "))
					.stream().map(Integer::parseInt)
					.collect(Collectors.toList());
		}
		return list;
	}
	
	static void reculsive(int index,int depth, int result, int add, int sub, int mul,int div,List<Integer> numbers) {
		if(index == depth) {
			System.out.println(result);
			max = Math.max(result, max);
			min = Math.min(result, min);
			return;
		}
		if(add!=0) reculsive(index+1, depth, result + numbers.get(index), add-1, sub, mul, div,numbers);
		if(sub!=0) reculsive(index+1, depth, result - numbers.get(index), add, sub-1, mul, div,numbers);
		if(mul!=0) reculsive(index+1, depth, result * numbers.get(index), add, sub, mul-1, div,numbers);
		if(div!=0) {
			int resultTmp;
			if (result/numbers.get(index) > 0 ) {
				resultTmp = result/numbers.get(index);
			}else {
				resultTmp = -(-result/numbers.get(index));
			}
			reculsive(index+1, depth, resultTmp, add, sub, mul, div-1,numbers);
		}
	}
	
	
	
}
