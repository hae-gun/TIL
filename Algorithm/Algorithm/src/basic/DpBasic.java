package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DpBasic {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num=0;
		int count=0;
		try {
			num = Integer.valueOf(br.readLine());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println(num);
		while(true) {
			if(num==1) {
				break;
			}
			if(num%3==0) {
				num /=3;
				count++;
				System.out.println(num);
			}else if(num%2==0) {
				num /= 2;
				count++;
				System.out.println(num);
			}
			num-=1;
			count++;
			System.out.println(num);
			
			
		}
		System.out.println(count);
		
	}
}
