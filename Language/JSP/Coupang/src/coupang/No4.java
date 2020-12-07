package coupang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class No4 {
	public static void main(String[] args) {
		// 배송지 문제..
		// 먼저 그래프를 생성하기.
//		String depar = "SEOUL";
//		String hub = "DAEGU";
//		String dest = "YEOSU";
		String depar = "ULSAN";
		String hub = "SEOUL";
		String dest = "BUSAN";
		String[][] roads = { { "ULSAN", "BUSAN" }, { "DAEJEON", "ULSAN" }, { "DAEJEON", "GWANGJU" },
				{ "SEOUL", "DAEJEON" }, { "SEOUL", "ULSAN" }, { "DAEJEON", "DAEGU" }, { "GWANGJU", "BUSAN" },
				{ "DAEGU", "GWANGJU" }, { "DAEGU", "BUSAN" }, { "ULSAN", "DAEGU" }, { "GWANGJU", "YEOSU" },
				{ "BUSAN", "YEOSU" } };
		
		String[][] roads2 = { { "SEOUL", "DAEJEON" }, { "ULSAN", "BUSAN" }, { "DAEJEON", "ULSAN" },
				{ "DAEJEON", "GWANGJU" }, { "SEOUL", "ULSAN" }, { "DAEJEON", "BUSAN" }, { "GWANGJU", "BUSAN" } };
		System.out.println("before");
		solution(depar, hub, dest, roads2);
		System.out.println("end");
	}

	public static int solution(String depar, String hub, String dest, String[][] roads) {
		int answer = 1;

		HashMap<String, ArrayList<String>> map = new HashMap<>();
		for (String[] set : roads) {
			if (!map.containsKey(set[0])) {
				ArrayList<String> line = new ArrayList<>();
				line.add(set[1]);
				map.put(set[0], line);
			} else {
				ArrayList line = map.get(set[0]);
				line.add(set[1]);
				map.put(set[0], line);
			}
		}
		int i = 0;

		// 총 경로 -> 출발지에서 경유지로 가는 경우의 수 * 경유지에서 도착지로 가는 경우의
		// 출발지 에서 경우지로 가는 경로의 수
		LinkedList<String> stack = new LinkedList<String>();
		for (String firstSet : map.get(depar)) {
			stack.addLast(firstSet);
		}

		HashMap<String, Boolean> check = new HashMap<String, Boolean>();
		for (String loc : map.keySet()) {
			check.put(loc, false);
		}
//		System.out.println(map);
//		System.out.println(check);
		while (!stack.isEmpty()) {
			String loc = stack.removeLast();
//			System.out.println(loc);
			if (map.containsKey(loc) && !check.get(loc)) {
				for (String des : map.get(loc)) {
					stack.addLast(des);
					if (des.equals(hub)) {
						i++;
					}
				}
			}
//			System.out.println("to hub:" + i);
		}
		answer *= i;
		i = 0;
		check = new HashMap<String, Boolean>();
		for (String loc : map.keySet()) {
			check.put(loc, false);
		}
		
		
		for (String firstSet : map.get(hub)) {
			stack.addLast(firstSet);
		}
		while (!stack.isEmpty()) {
			String loc = stack.removeLast();
//			System.out.println(loc);
			if (map.containsKey(loc) && !check.get(loc)) {
				for (String des : map.get(loc)) {
					stack.addLast(des);
					if (des.equals(dest)) {
						i++;
					}
				}
			}
//			System.out.println("to dest" + i);
		}

		answer *= i;
//		System.out.println(map);
//		System.out.println(i);
		System.out.println(answer);
		return answer;
	}

}
