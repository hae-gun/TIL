import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

class team {
	String I;
	String you;
	double[] rate;
	double win, draw, lose;

	team(String I, String you, double win, double draw, double lose) {
		this.I = I;
		this.you = you;
		this.rate[0] = win;
		this.rate[1] = draw;
		this.rate[2] = lose;

	}
}

public class Winlose {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);

		String s = scan.nextLine();
		String[] team = s.split(" ");
		int count = team.length;

		LinkedList<String> sets = new LinkedList<String>();

		String[] winRate = new String[count * (count - 1) / 2];
		HashMap<String[],String[]> set = new HashMap<String[], String[]>();
		
		
		for (int i = 0; i < winRate.length; i++) {

			winRate[i] = scan.nextLine();
			String[] rate = winRate[i].split(" ");
			String[] teams = {rate[0],rate[1]};
			String[] rates = {rate[2],rate[3],rate[4]};
			set.put(teams, rates);
		}

//		for (String set : winRate) {
//			String[] cut = set.split(" ");
//			sets.addFirst();
////					new team(cut[0], cut[1], Double.valueOf(cut[2]), Double.valueOf(cut[3]), Double.valueOf(cut[4])));
//
//		}
		for(int i=0; i<team.length;i++) {
			LinkedList<String> temp = sets;
			while(temp.contains(team[i])) {
				String tempString = temp.removeFirst();
				
				
				
			}
		}
		

	}

}
