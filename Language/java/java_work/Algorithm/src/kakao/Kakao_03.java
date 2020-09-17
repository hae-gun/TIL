package kakao;

import java.util.ArrayList;
import java.util.Iterator;

public class Kakao_03 {

	public static void main(String[] args) {
		String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };

		String[] query = { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };
		int[] result = solution(info, query);
		
		for(int i: result) {
			System.out.print(i+" ");
		}

	}

	public static int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		Info[] infos = new Info[info.length];

		for (int i = 0; i < infos.length; i++) {
			String[] tmp = info[i].split(" ");
			infos[i] = new Info(tmp[0], tmp[1], tmp[2], tmp[3], Integer.parseInt(tmp[4]));
		}

		Info[] querys = new Info[query.length];

		for (int i = 0; i < querys.length; i++) {
			String[] tmp = query[i].split(" and ");
			String[] ttmp = tmp[3].split(" ");
			querys[i] = new Info(tmp[0], tmp[1], tmp[2], ttmp[0], Integer.parseInt(ttmp[1]));

		}

//		for (Info s : infos) {
//			System.out.println(s);
//		}
//		System.out.println("-------------");
		int idx=0;
		for (Info q : querys) {
			
			ArrayList<Info> tmp = new ArrayList<Info>();
			
			String lan = checkNull(q.lan);
			String position = checkNull(q.position);
			String year = checkNull(q.year);
			String food = checkNull(q.food);
			int score = q.score;
			
			
			
//			System.out.printf("%s %s %s %s %d\n",lan,position,year,food,score);
			for (Info mem : infos) {
				if(mem.score>=score) {
					tmp.add(mem);
				}
			}
//			for (Info tm:tmp) {
//				System.out.println(tm);
//			}
//			System.out.println("============");
			Iterator<Info> iter = tmp.iterator();
			if(lan != null) {
//				while(iter.hasNext()) {
//					Info mem = iter.next();
//					System.out.println("---"+tmp);
//					iter.remove();
//					if(!lan.equals(mem.lan)) {
//						tmp.remove(mem);
//					}
//					System.out.println("tmp:"+tmp);
//				}
//				System.out.println(tmp);
//				System.out.println("lan: "+lan);
				ArrayList<Info> tt = new ArrayList<>();
				for(Info mem:tmp) {
					String chk = mem.lan;
					if(chk.equals(lan)) {
						tt.add(mem);
					}
				}
				tmp = tt;
//				System.out.println("*********");
//				System.out.println(tmp);
//				System.out.println("*********");
			}
			
			if(position != null) {
				ArrayList<Info> tt = new ArrayList<>();
				for(Info mem:tmp) {
					String chk = mem.position;
					if(chk.equals(position)) {
						tt.add(mem);
					}
				}
				tmp = tt;
			}
			
			if(year != null) {
				ArrayList<Info> tt = new ArrayList<>();
				for(Info mem:tmp) {
					String chk = mem.year;
					if(chk.equals(year)) {
						tt.add(mem);
					}
				}
				tmp = tt;
			}
			
			if(food != null) {
				ArrayList<Info> tt = new ArrayList<>();
				for(Info mem:tmp) {
					String chk = mem.food;
					if(chk.equals(food)) {
						tt.add(mem);
					}
				}
				tmp = tt;
			}
			
//			System.out.println(tmp);
			answer[idx++] = tmp.size();
			
			
			

		}

		return answer;
	}
	
	public static String checkNull(String s) {
		return s.equals("-") ? null : s; 
	}
	

}

class Info {

	String lan;
	String position;
	String year;
	String food;
	int score;
	int code = 0;
	public Info(String lan, String position, String year, String food, int score) {
		this.lan = lan;
		this.position = position;
		this.year = year;
		this.food = food;
		this.score = score;
		this.code = this.lan.charAt(0)+this.position.charAt(0)+this.year.charAt(0)+this.food.charAt(0)+score;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		Info tmp = (Info)obj;
		if(this.code ==tmp.code) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "Info [lan=" + lan + ", position=" + position + ", year=" + year + ", food=" + food + ", score=" + score
				+ "]";
	}

}
