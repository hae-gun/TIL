package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CleanRobot {
	
	
	
		// 0 북 1 동 2 남 3 서  
		int[] dx = { -1, 0, 1, 0};
		int[] dy = { 0, 1, 0, -1};
	
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		List<Integer> NM = (List<Integer>) readLine(br," ");
		
		int N = NM.get(0);
		int M = NM.get(1);
		
		int[][] map = new int[N][M];
		
		for(int i=0; i<map.length; i++) {
			map[i] = setArray(br, " ");
		}
		
		List<Integer> RCD = (List<Integer>)readLine(br," ");
		
		int R = RCD.get(0);
		int C = RCD.get(1);
		int dir = RCD.get(2);
		
		
		
		for(int[] line:map) {
			
			System.out.println(Arrays.toString(line));
		}
		
	}
	
	public static List<?> readLine(BufferedReader br, String reg) throws IOException{
		return Arrays.asList(br.readLine().split(reg))
				.stream().map(Integer::parseInt)
				.collect(Collectors.toList());
	}
	
	public static int[] setArray(BufferedReader br, String reg) throws IOException {
		List<Integer> list = (List<Integer>) readLine(br, reg);
		int[] result = new int[list.size()];
		
		for(int idx = 0; idx<list.size(); idx++) {
			result[idx] = list.get(idx);
		}
		
		return result;
	}
	
	
}
