package api04_date_time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.TimeZone;

public class DateTimeEx {
	public static void main(String[] args) {
		//
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		String ptn = "yyyy년 MM월 dd일 h시 m분 s초";

		DateTimeFormatter dft = DateTimeFormatter.ofPattern(ptn);
		String nowStr = now.format(dft);

		System.out.println(nowStr);

		String[] tz = TimeZone.getAvailableIDs();
		for (String z : tz) {
			System.out.println(z);
		}
		
		TimeZone euTz = TimeZone.getTimeZone("Europe/Rome");
		System.out.println();
		
		Calendar cal = Calendar.getInstance(euTz);
		int hour = cal.get(Calendar.HOUR);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		System.out.printf("Rome Time -- %d : %d : %d",hour, min,sec);
		
	}
}
