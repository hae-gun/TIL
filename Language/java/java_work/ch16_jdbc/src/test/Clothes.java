package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Clothes {
	public static void main(String[] args) {

		String[][] clothes = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
				{ "green_turban", "headgear" } };
//		String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
		System.out.println(solution(clothes));

	}

	public static int solution(String[][] clothes) {
		int answer = 0;
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (String[] cloth : clothes) {
			if (map.containsKey(cloth[1])) {
				map.put(cloth[1], map.get(cloth[1]) + 1);
			} else {
				map.put(cloth[1], 1);
			}
		}
		Object[] values = map.values().toArray();

//	        ArrayList<Integer> values = (ArrayList<Integer>) map.values();
//	        for(Object i:values) {
//	        	System.out.println((int)i);
//	        }
//	        System.out.println("---------");

		// 해당 숫자들의 모든 부분집합들을 구한후 각 부분집합의 원소들의 곱을 합친다.
		System.out.println(map);

//		for (int i = 0; i < values.length; i++) {
//			int start = (int) values[i];
////	        	System.out.println(start);
//			answer += start;
//			for (int j = i + 1; j < values.length; j++) {
//				start *= (int) values[j];
////	        		System.out.println(start);
//				answer += start;
////	        		System.out.println("---------");
//			}
//		}

		Set<Integer> mySet = new HashSet<Integer>();
//	        System.out.println(map);
		for (Integer i : map.values()) {
			mySet.add(i);
		}

		ArrayList<Integer> a = new ArrayList<>();
		for (Set<Integer> s : Clothes.powerSet(mySet)) {
			if (!s.isEmpty()) {
				int pow = 1;
				for (Integer i : s) {
					pow *= i; 
				}
				a.add(pow);
			}
		}
		System.out.println(a);
		for(int i :a) {
			answer+=i;
		}
		return answer;
	}

	public static <T> Set<Set<T>> powerSet(Set<T> originalSet) {
		Set<Set<T>> sets = new HashSet<Set<T>>();
		if (originalSet.isEmpty()) {
			sets.add(new HashSet<T>());
			return sets;
		}
		List<T> list = new ArrayList<T>(originalSet);
		T head = list.get(0);
		Set<T> rest = new HashSet<T>(list.subList(1, list.size()));
		for (Set<T> set : powerSet(rest)) {
			Set<T> newSet = new HashSet<T>();
			newSet.add(head);
			newSet.addAll(set);
			sets.add(newSet);
			sets.add(set);
		}
		return sets;
	}

}
