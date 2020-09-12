package kakao;

public class Kakao_5 {
	public static void main(String[] args) {
		String play_time = "02:03:55";
		String adv_time = "00:14:15";
		String[] logs = { "01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29",
				"01:37:44-02:02:30" };
		String result = solution(play_time, adv_time, logs);
		System.out.println(result);
	}

	public static String solution(String play_time, String adv_time, String[] logs) {
		String answer = "";
		// 플레이 타암 만들기
		String[] tmp = play_time.split(":");
		int h = Integer.parseInt(tmp[0]);
		int m = Integer.parseInt(tmp[1]);
		int s = Integer.parseInt(tmp[2]);

		Time playTime = new Time(h, m, s);

		tmp = adv_time.split(":");
		h = Integer.parseInt(tmp[0]);
		m = Integer.parseInt(tmp[1]);
		s = Integer.parseInt(tmp[2]);

		Time advTime = new Time(h, m, s);

		if(playTime.calPoint()==advTime.calPoint()) {
			answer = "00:00:00";
			return answer;
		}
		
		
		int[] playMap = new int[playTime.calPoint() + 1];

		People[] peoples = new People[logs.length];

		for (int i = 0; i < logs.length; i++) {
			peoples[i] = new People(logs[i]);
		}
		for (People p : peoples) {
//			System.out.println(p);
			int sTime = p.getStartPoint();
			int eTime = p.getEndPoint();
			for (int i = sTime; i <= eTime; i++) {
				playMap[i] += 1;
			}

		}
		int max = 0;
		for (int i = 0; i < playMap.length; i++) {
			max = Math.max(max, playMap[i]);
//			System.out.print(playMap[i]+" ");

		}
		int index = 0;
		boolean flag = false;
		for (int i = 0; i < playMap.length; i++) {
			if (playMap[i] == max) {
				index = i;
				flag = true;
			}
			if(flag && playMap[i] != max) {
				break;
			}
		}
//		System.out.println("max start index:"+index);

		// index: 가장 많이 겹친 구간의 마지막 시간.
		// 광고 시작시간 = index - 광고 길이
//		index -= advTime.calPoint();
		
		if(index<advTime.calPoint()) {
			for(int i=0; i< playMap.length; i++) {
				if(playMap[i]==1) {
					index = i;
					break;
				}
			}
		}else {
			index -= advTime.calPoint();
		}
		
		String sh = index / 3600 >= 10 ? "" + index / 3600 : "0" + index / 3600;
		index %= 3600;
		String sm = index / 60 >= 10 ? "" + index / 60 : "0" + index / 60;
		index %= 60;
		String ss = index >= 10 ? "" + index : "0" + index;
//		System.out.printf("%d : %d : %d",sh,sm,ss);

		answer = sh + ":" + sm + ":" + ss;
		return answer;
	}

}

class People {
	Time startTime;
	Time endTime;

	public People(String line) {
		String[] tmp = line.split("-");
		String[] tmp2 = tmp[0].split(":");

		int hour = Integer.parseInt(tmp2[0]);
		int min = Integer.parseInt(tmp2[1]);
		int second = Integer.parseInt(tmp2[2]);

		this.startTime = new Time(hour, min, second);

		tmp2 = tmp[1].split(":");
		hour = Integer.parseInt(tmp2[0]);
		min = Integer.parseInt(tmp2[1]);
		second = Integer.parseInt(tmp2[2]);

		this.endTime = new Time(hour, min, second);

	}

	public int getStartPoint() {
		return this.startTime.calPoint();
	}

	public int getEndPoint() {
		return this.endTime.calPoint();
	}

	@Override
	public String toString() {
		return "People [startTime=" + startTime + ", endTime=" + endTime + "]";
	}

}

class Time {
	int hour;
	int min;
	int second;

	public Time(int hour, int min, int second) {
		this.hour = hour;
		this.min = min;
		this.second = second;
	}

	public int calPoint() {
		return this.second + 60 * this.min + 3600 * this.hour;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return hour + ":" + min + ":" + second;
	}
}
