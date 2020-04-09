package test;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class TestNo04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution4 sol = new Solution4();
		String[][] snapshots = { { "ACCOUNT1", "100" }, { "ACCOUNT2", "150" } };
		String[][] transactions = { { "1", "SAVE", "ACCOUNT2", "100" }, { "2", "WITHDRAW", "ACCOUNT1", "50" },
				{ "1", "SAVE", "ACCOUNT2", "100" }, { "4", "SAVE", "ACCOUNT3", "500" },
				{ "3", "WITHDRAW", "ACCOUNT2", "30" } };

		System.out.println(sol.solution(snapshots, transactions));
	}

}

class Solution4 {
	public String[][] solution(String[][] snapshots, String[][] transactions) {
		int money = 0;
		LinkedHashMap<String, Integer> Client = new LinkedHashMap();
		for (String[] s : snapshots) {
			Client.put(s[0], Integer.valueOf(s[1]));
		}
		System.out.println(Client.toString());

		LinkedHashMap<String, ArrayList<String>> trans = new LinkedHashMap();
		for (String[] s : transactions) {
			ArrayList<String> list = new ArrayList();
			for (int i = 1; i < s.length; i++) {
				list.add(s[i]);
			}
			trans.put(s[0], list);
		}

		System.out.println(trans);
		for (int i = 0; i < trans.size(); i++) {
			if (Client.containsKey(trans.get(String.valueOf(i + 1)).get(1))) {
				if (trans.get(String.valueOf(i + 1)).get(0).equals("SAVE")) {
					money = Client.get(trans.get(String.valueOf(i + 1)).get(1))
							+ Integer.valueOf(trans.get(String.valueOf(i + 1)).get(2));
					Client.replace(trans.get(String.valueOf(i + 1)).get(1), money);
				} else if (trans.get(String.valueOf(i + 1)).get(0).equals("WITHDRAW")) {
					money = Client.get(trans.get(String.valueOf(i + 1)).get(1))
							- Integer.valueOf(trans.get(String.valueOf(i + 1)).get(2));
					Client.replace(trans.get(String.valueOf(i + 1)).get(1), money);
				}
			} else {
				if (trans.get(String.valueOf(i + 1)).get(0).equals("SAVE"))
					Client.put(trans.get(String.valueOf(i + 1)).get(1),
							Integer.valueOf(trans.get(String.valueOf(i + 1)).get(2)));
			}
		}

		System.out.println(Client.toString());

		String[][] answer;
		Object[] keys = Client.keySet().toArray();
		Object[] values = Client.values().toArray();
		
	
		answer = new String[keys.length][2];
		for (int i = 0; i < keys.length; i++) {
			answer[i][0] = (String) keys[i];
			answer[i][1] = values[i].toString();
			System.out.println(answer[i][0] + " " + answer[i][1]);
		}
		
		return answer;
	}
}
