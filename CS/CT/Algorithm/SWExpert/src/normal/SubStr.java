package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SubStr {
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
//		HashMap<String, Integer> map = new HashMap<>();
		Set<String> set = new HashSet<>();
		int count = 0;
		
		for(int i=0; i<str.length(); i++) {
			String fStr = "";
			for(int j=i; j<str.length(); j++) {
				fStr += str.charAt(j);

//				System.out.println("S::" + fStr);
				String tmp = masking(i,j,str);
				
				if(tmp.contains(fStr)) {
					set.add(fStr);
				}
//				System.out.println(tmp);
//				String temp = str.substring(0,i);
//				temp += masking(fStr.length());
//				System.out.println("____" + str.substring(j));
//				temp += str.substring(i, j);
//
//				System.out.println("T:: "+ temp);
			}
			
		}
		System.out.println(set.size());
		
		
	}
	public static String masking(int sIdx, int eIdx, String preString) {
		
		String tmp = "";
//		for(int i=0; i<length; i++) tmp += '*';
		
//		char[] set = preString.toCharArray();
//		
//		for(int i=sIdx; i<=eIdx; i++) {
//			set[i] = '*';
//		}
		
//		 0 a      1 b 2 c       3 d
		if(sIdx != 0) 
			tmp += preString.substring(0,sIdx);		
		tmp += "-";
		if(eIdx<preString.length()-1)
			tmp += preString.substring(eIdx+1);
		
		
		return tmp;
	}
}


