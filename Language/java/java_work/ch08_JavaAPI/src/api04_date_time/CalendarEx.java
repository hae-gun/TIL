package api04_date_time;

import java.util.Calendar;

public class CalendarEx {
	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)+1; // month 는 +1 필요
		int day = now.get(Calendar.DAY_OF_MONTH);
		int week = now.get(Calendar.DAY_OF_WEEK);
		System.out.printf("%d년%d월%d일 %d요일\n",year,month,day,week);
		
		System.out.println(Calendar.SUNDAY);
		
	}
}	
