package coupang;

public class No2 {
	public static void main(String[] args) {
		String[] customers = { "10/01 23:20:25 30", "10/01 23:25:50 26", "10/01 23:31:00 05", "10/01 23:33:17 24",
				"10/01 23:50:25 13", "10/01 23:55:45 20", "10/01 23:59:39 03", "10/02 00:10:00 10" };
		int n = 3;
		int result = solution(n, customers);
	}

	private static int solution(int n, String[] customers) {

		int answer = 0;

		for (String test : customers) {
			System.out.println(new Customers(test));
		}
		int[] kiosk = new int[n];
		int[] count = new int[n];

		for (String test : customers) {
			Customers temp = new Customers(test);
			boolean chk = false;
			for (int i = 0; i < kiosk.length; i++) {
				if (kiosk[i] == 0) {
					kiosk[i] = temp.endTime;
					count[i]++;
					chk = true;
					break;
				}
			}
			if (chk)
				continue;
			int waitTime = 0;
			// 사용할 수 있는 키오스크 있나 없나 확인.
			for (int i = 0; i < kiosk.length; i++) {
				boolean flag = false;
				if(kiosk[i]<temp.startTime) {
					flag = true;
					kiosk[i] = temp.startTime;
				}
				if(flag) continue;
				waitTime = Math.max(waitTime, kiosk[i]);
			}

		}

		for (int i : count) {
			System.out.println(i);
		}

		return answer;
	}

}

class Customers {
	String day;
	int startTime;
	int endTime;

	public Customers(String info) {
		this.day = makeDay(info);
		this.startTime = makeTimeS(info);
		this.endTime = makeTimeE(info);
	}

	String[] infoSeperate(String info) {

		String[] result = info.split(" ");
		return result;
	}

	String makeDay(String info) {
		return infoSeperate(info)[0];
	}

	private int makeTimeS(String info) {
		return stringToTime(infoSeperate(info)[1]);
	}

	private int makeTimeE(String info) {
		String startTime = infoSeperate(info)[1];
		int minute = Integer.parseInt(infoSeperate(info)[2]) * 60;
		// TODO Auto-generated method stub
		return stringToTime(startTime) + minute;
	}

	int stringToTime(String time) {
		int result = 0;
		String[] temp = time.split(":");

		result += Integer.parseInt(temp[2]);
		result += Integer.parseInt(temp[1]) * 60;
		result += Integer.parseInt(temp[0]) * 60 * 60;

		return result;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.day + "--" + this.startTime + "--" + this.endTime;
	}

}
