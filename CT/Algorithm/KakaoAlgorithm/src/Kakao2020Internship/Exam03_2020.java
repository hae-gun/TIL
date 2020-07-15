package Kakao2020Internship;

import java.util.Collection;
import java.util.HashMap;

public class Exam03_2020 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Boolean> jweryset = new HashMap<String, Boolean>();
		String[] gems = { "AA", "AB", "AC", "AA", "AC" };
		for (String s : gems) {
			jweryset.put(s, false);
		}
		boolean flag = true;
		int i = 0;
		int indexF = 0, indexE = 0;
		int min = 1000000;
		while (flag) {
			HashMap<String, Boolean> temp = new HashMap<String, Boolean>();
			for (String s : jweryset.keySet()) {
				temp.put(s, false);
			}
//			for(Boolean s : temp.values()) {
//				System.out.print(s);
//			}
//			System.out.println();
			
			if (i == gems.length) {
				indexF = 0;
				indexE = gems.length - 1;

				
				break;
			}
			if (temp.size() == 1) {
				indexF = 0;
				indexE = 0;
				break;
			}

			indexF = i;
			int lineLength = 0;

			

			for (int j = i; j < gems.length; j++) {

				if (checkall(temp.values())) {
					temp.replace(gems[j], true);
					System.out.println(j);
					
					
				} else {
					indexE = j;
					flag = false;
					break;
				}
			

			}
			
//			for(Boolean s : temp.values()) {
//				System.out.print(s);
//			}
//			for(Boolean chk : temp.values()) {
//				if(chk) {
//					flag = false;
//				}else {
//					flag = true;
//					break;
//				}
//				
//			}

			i++;

		}
		System.out.println((indexF + 1) + "  " + (indexE));

	}
	static boolean checkall(Collection<Boolean> set) {
		boolean flag = true;
		for(Boolean s:set) {
			if(!s) {
				flag = false;
			}else {
				flag = true;
			}
		}
		return flag;
	}

}
