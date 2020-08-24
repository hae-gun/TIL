package thisisalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class BigNumber {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n,m,k;
		
		try {
			System.out.println("n >>");
			n=Integer.parseInt(br.readLine());
			System.out.println("m >>");
			m=Integer.parseInt(br.readLine());
			System.out.println("k >>");
			k=Integer.parseInt(br.readLine());
			
			System.out.println("data >>");
			String data = br.readLine();
			
			String[] sSet = data.split(" ");
			
			int[] iset = Arrays.stream(sSet)
								.mapToInt(p->Integer.parseInt(p))
								.sorted()
								.toArray();
			int max = iset[iset.length-1];
			int secondMax = iset[iset.length-2];
			
			int count = (m/(k+1)) *k;
			count += m %(k+1);
			
			int result = max*count;
			result += (m-count) * secondMax;
			
			System.out.println(result);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
