package array;

import java.util.Arrays;

public class Arr04 {
	public static void main(String[] args) {
				
		String[][] myClass = {{"안성용","명준호","최지현","최혜근"},
						{"김완서","김진수","최영훈","김효","김민건","서승완"},
						{"유정현","조래준","김성준", "박원석","이동욱","변석봉"},
						{"김상은","안수민","황동기","김지언"}};
		
		System.out.println(myClass.length);
//		for(String s : myClass) {
//			if(s.charAt(0)=='김')
//			System.out.println(s);
//		}
		
		//1분단: 안~~
		System.out.println(Arrays.toString(myClass));
		int line=0;
		for(String[] row : myClass) {
			line++;
			System.out.print(line + "분단: ");
			for(String col : row) {
				System.out.print(col + " ");
			}
			System.out.println();
		}
	}
}
