package ch10_Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Al02 {
	public static void main(String[] args) {
		ArrayList<Integer> intList = new ArrayList<>();
		
		intList.add(new Integer(1));
		intList.add(new Integer(5));
		intList.add(new Integer(2));
		intList.add(new Integer(3));
		intList.add(new Integer(6));
		intList.add(new Integer(4));
		
		
		List<Integer> intList2 = new ArrayList<Integer>(intList.subList(1, 4)); // 1~ 3 까지 (4번 앞까지)
		print("subList()",intList,intList2);

		// 정렬 Collections class 사용 : 오름차순 
		Collections.sort(intList);
		Collections.sort(intList2);
		print("sort()",intList,intList2);
		
		// 순서 뒤집기. : 정렬하고 사용하면 내림차순.
		Collections.reverse(intList);
		Collections.reverse(intList2);
		print("reverse()",intList,intList2);
		
		
		// contains() : 	특정 오브젝트를 포함하고 있는지 불리언 반환.
		System.out.println("intList.contains(7): "+ intList.contains(7));
		// containsAll() : 특정 리스트의 전체 요소를 모두 포함하고 있는지 불리언 반환. 부분집합 여부 확인
		System.out.println("intList.containsAll(intList2): "+intList.containsAll(intList2));
		intList2.add(8);
		System.out.println("intList.containsAll(intList2): "+intList.containsAll(intList2));
		
		System.out.println(intList);
		intList.set(2, 100); // index 값을 변
		System.out.println(intList);
//		intList.add(2);
//		retainAll() :; 특정 리스트의 요소와 중복되는 것만 남기고 나머지 삭제
		System.out.println(intList.retainAll(intList2));
		System.out.println(intList);
		
	}

	private static void print(String string, ArrayList<Integer> intList, List<Integer> intList2) {
		System.out.printf("------ %s ------ \n",string);
		System.out.println(intList);
		System.out.println(intList2);
		System.out.println("----------------------");
	}
	
	
}
