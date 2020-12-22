package coupang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
	public static void main(String[] args) throws IOException {
		
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a=Integer.parseInt(br.readLine());
		double result = 0;
		
		double test= Math.sqrt(a);
		
		
		int chk = (int)((test - (int)test) * 10);
		if(chk != 0) {
		for(int N=0; N<=7;N++) {
			
			double plus = 1/Math.pow(10, N);
			for(int j=0; j<1000; j++) {
				result += plus;
				if(Math.pow(result+plus, 2)>=a) {
					break;
				}
			}
		}
		System.out.printf("root %d = %.7f",a,result);
		}else {
			System.out.printf("root %d = %.2f",a,test);
		}
		
	}
}
