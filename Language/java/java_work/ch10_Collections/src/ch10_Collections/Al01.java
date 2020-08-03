package ch10_Collections;

import java.util.ArrayList;
import java.util.List;

public class Al01 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		list.add("java");
		list.add("db");
		list.add("jsp");
		
		System.out.println(list);
		
		list.add(1,"Web standard");
		list.add(1,"JDBC");
		System.out.println(list);
		
		int size = list.size();
		
		String skill = list.get(3);
		
		System.out.println("my skill: "+skill);
		
		for(String s : list) {
			System.out.println(s);
		}
		
		// 삭제 : remove(idx) or remove(E) - idx 는 하나 E는 같은요소라면 첫번째 요소 삭제
		// 삭제를 하면서 해당 객체를 반환한다.
		String str = list.remove(1);
		System.out.println(str);
		System.out.println(list);
		
		if(list.remove("jsp")) {
			System.out.println("jsp 삭제완료");
		}else {
			System.out.println("jsp 없음");
		}
		
		
	}
}
