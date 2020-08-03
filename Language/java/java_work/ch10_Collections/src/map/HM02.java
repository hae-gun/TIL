package map;

import java.util.HashMap;
import java.util.Scanner;

public class HM02 {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();

		map.put("sky", "1234");
		map.put("land", "2345");
		map.put("ocean", "2839");

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("id>>>");
			String id = sc.nextLine().toLowerCase().trim();

			if (!map.containsKey(id)) {
				System.out.println("입력한 id가 없습니다. 다시입력");
				continue;
			}

			System.out.println("password>>");
			String pw = sc.nextLine().trim();
			
			if (!(map.get(id).equals(pw))) {
				System.out.println("비밀번호가 틀림");
				continue;
			} else {
				System.out.println("로그인 성공");
				break;
			}

		}
		System.out.println("program exit");
	}
}
