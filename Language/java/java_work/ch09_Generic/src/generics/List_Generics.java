package generics;

import java.util.ArrayList;
import java.util.List;

public class List_Generics {
	public static void main(String[] args) {
		
		List list = new ArrayList();
		
		list.add("Hi");
		list.add(true);
		list.add(1234);
		
		for(Object o : list) {
			System.out.println(o);
		}
		
		String str =(String)list.get(0);
//		String str2 =(String)list.get(1);
		
//		System.out.println(str2);
		
		int sum = 7 + (int)list.get(2);
		
		// Generics 만든이유
		
		List<String> li = new ArrayList<String>();
		li.add("asdf");
		// Error
//		li.add(123);
		
	}
}
