package string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CroatiaAlphabet {

	public static void main(String[] args) throws IOException{
		String input="";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		input = br.readLine().trim();
		
		
		
		String[] set = { "c=", "c-", "dz=", "d-", "l1", "lj", "n1", "nj", "s1", "s=", "z1", "z=" };
		
		for(int i=0; i<set.length;i++) {
			input = input.replaceAll(set[i], "*");
		}
		
		int result =input.length() ;
		
		bw.write(result+"");
		bw.flush();
		
		 br.close(); bw.close();
		
	}
}