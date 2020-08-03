package set.treeSet;

import java.util.TreeSet;

public class TS01 {
	public static void main(String[] args) {
		// 자동정렬 - 이진트리 사용
		TreeSet<String> set = new TreeSet<String>();
		
		String from = "b";
		String to = "dc";
		
		set.add("car");
		set.add("area");
		set.add("ball");
		set.add("asdf");
		set.add("qweqwe");
		set.add("cxzcxz");
		set.add("ss");
		set.add("zzzzz");
		set.add("dack");
		set.add("dog");
		System.out.println(set);
		
		// b부터 d전까지 출력
		System.out.println(set.subSet(from, to));
	}
}
