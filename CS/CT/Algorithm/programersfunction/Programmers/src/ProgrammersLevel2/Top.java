package ProgrammersLevel2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Top {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		
		int[] heights = {6,9,5,7,4};
		
		
		
		
		int[] result = solution(heights);
		
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for(int i : result) {
			sb.append(i);
		0	sb.append(",");
		}
		
		sb.deleteCharAt(sb.length()-1);
		sb.append("]");
		bw.write(sb.toString());
		br.close();
		bw.close();
		
	}
		public static int[] solution(int[] heights) {
			int[] answer = new int[heights.length];
			
			for(int i = answer.length-1; i >0; i--) {
				for(int j = i-1; j>=0; j--) {
					if(heights[i]<heights[j]) {
						answer[i] = j+1;
						break;
					}
				}
			}
			
			
			return answer;
		}
	

}
	