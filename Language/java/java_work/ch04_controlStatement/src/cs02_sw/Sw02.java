package cs02_sw;

import java.util.Scanner;

public class Sw02 {
	public static void main(String[] args) {
		int month;
		String season = "";
		System.out.println("태어난 달입력>>>");

		Scanner sc = new Scanner(System.in);
		month = sc.nextInt();
		boolean check = true;
		switch (month) {
		case 12:
		case 1:
		case 2:
			season = "겨울";
			break;
		case 3:
		case 4:
		case 5:
			season = "봄";
			break;
		case 6:
		case 7:
		case 8:
			season = "여름";
			break;
		case 9:
		case 10:
		case 11:
			season = "가을";
			break;

		default:
			check = !check;
			System.out.println("Wrong input, try again");
			break;
		}
		if (check)
			System.out.printf("%d월에 태어난 당신은 사랑스런 %s의 선물", month, season);
	}
}
