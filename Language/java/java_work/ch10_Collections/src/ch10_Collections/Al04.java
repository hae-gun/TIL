package ch10_Collections;

import java.util.ArrayList;
import java.util.List;

public class Al04 {
	public static void main(String[] args) {

		final int LIMIT = 10;
		String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&()ZZas";

		int length = source.length();
		System.out.println(length); // 43

		List<String> list = new ArrayList<>(length / LIMIT + 1);
			
		for (int i = 0; i < length; i += LIMIT) {
			
			if(i+LIMIT>length) {
				// i 부터 끝까지.
				list.add(source.substring(i));
			}else {
				list.add(source.substring(i, i+LIMIT));
			}
			
		}

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}
}
