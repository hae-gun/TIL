package ch10_Collections;

import java.util.Vector;

// Thread Safe: 단일 스레드로만 동작, 자동 싱크로
public class Vec01 {
	public static void main(String[] args) {
		Vector<Integer> v = new Vector<>(5);
		v.add(1);
		v.add(2);
		v.add(3);
		v.add(4);
		
		print(v);
		
		v.trimToSize();
		print(v);
		
		v.ensureCapacity(50);
		print(v);
		
		Vector<Integer> v2 = new Vector<Integer>();
		
		v2 = (Vector<Integer>)v.clone(); // 깊은 복사
		
		print(v);
		print(v2);
		
		v.clear();
		
		print(v);
		print(v2);
		
		
		
	}

	private static void print(Vector<Integer> v) {
		System.out.println(v);
		System.out.println("size: "+v.size());
		System.out.println("capacity: "+v.capacity());
		System.out.println("--------------");
		
	}
}
