package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HM01 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		
		map.put("tom", 77);
		// 중복시 나중값이 저장됨.
		map.put("tom", 88);
		map.put("pom", 12);
		map.put("jom", 32);
		map.put("som", 7547);
		map.put("aom", 123);
		map.put("mom", 71127);
		
		System.out.println(map);
		
		System.out.println("Entry : "+ map.size());
		
		System.out.println("tom's score: "+map.get("tom"));
		System.out.println("=======================================================");
		
		Set<String> keySet = map.keySet();
		for(String key:keySet) {
			System.out.printf("key: %s / value: %d\n",key,map.get(key));
		}
		System.out.println("=======================================================");
		// Iterator 이용.
		
		Iterator<String> iterator = keySet.iterator();
		
		while(iterator.hasNext()) {
			String key = iterator.next();
			System.out.printf("key: %s / value: %d\n",key,map.get(key));
		}
		
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		
		System.out.println("=======================================================");
		
		Iterator<Entry<String,Integer>> eIterator = entrySet.iterator();
		
		while(eIterator.hasNext()) {
			Entry<String,Integer> en = eIterator.next();
			String key = en.getKey();
			System.out.printf("name = %s, number = %d\n",key,map.get(key));
		}
		
		System.out.println("=======================================================");
		// 지울때. remove(key);
		System.out.println(map.remove("som")); // 반환값 : Value 값 반환.
		System.out.println(map.remove("som",7547));
		System.out.println(map);
		
		map.clear();
		
		System.out.println("=======================================================");
		System.out.println(map);
	}
}
