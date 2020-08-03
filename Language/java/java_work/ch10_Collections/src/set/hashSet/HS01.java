package set.hashSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HS01 {
	public static void main(String[] args) {
		// 중복 제거
		// 순서 무시
		Set<String> set = new HashSet<String>();
		
		String[] name = {"tom","sam","mom","tom","wam","pam","asdf"};
		System.out.println(Arrays.toString(name));
		
		for(String s: name) {
			set.add(s);
		}
		
		System.out.println(set);
		System.out.println("size: "+set.size());
		set.add(null);
		set.add(null);
		set.add(null);
		set.add(null);
		set.add(null);
		set.add(null);
		
		System.out.println(set);
		
		set.remove("mom");
		
		for(String s:set) {
			System.out.println(s);
		}
		System.out.println("===========================");
		
		// set 출력 Iterater 인터페이스 객체로 변환하여 hasNext()와 next() 메소드 사용하여 포함된 객체를 꺼낸다.
		
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			String str = iterator.next();
			System.out.println(str);
		}
		
		System.out.println("===========================");
		set.clear();
		
		if(set.isEmpty()) {
			System.out.println(set.size());
		}else {
			System.out.println(set);
		}
		
		
		
	}
}
