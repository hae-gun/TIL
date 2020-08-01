package api04_date_time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEx {
	public static void main(String[] args) {
		Date now = new Date();
		
		System.out.println(now);
		
		// duplicated
//		System.out.println(now.getYear());
//		System.out.println(now.getMonth()+1);
//		System.out.println(now.getDay());
		
		
		// 1970년 1월 1일 00:00:00 부터 현재까지의 milli second
		System.out.println(now.getTime());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MMMM.dd GGG hh:mm a");
		
		System.out.println(sdf.format(now));
		
		sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
		
		System.out.println(sdf.format(now));
		
	}
}	
