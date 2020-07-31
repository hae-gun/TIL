package class11_Enumeration;

import java.util.Calendar;

public class WeekEx {
	public static void main(String[] args) {
		
		Week today = null;
		
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		
		int weekday = cal.get(Calendar.DAY_OF_WEEK);
		switch(weekday) {
		
		case 1:
			today = Week.SUNDAY;
			break;
		case 2:
			today = Week.MONDAY;
			break;
		case 3:
			today = Week.TUESDAY;
			break; 
		case 4:
			today = Week.WEDNESDAY;
			break;
		case 5:
			today = Week.THURSDAY;
			break;
		case 6:
			today = Week.FRIDAY;
			break;
		case 7:
			today = Week.SATURDAY;
			
		}
		
		System.out.println("오늘 요일: " + today);
		
		if(today == Week.WEDNESDAY) {
			System.out.println("공부하는 날");
		}else {
			System.out.println("더 많이 공부하는 날");
		}
	}
}






