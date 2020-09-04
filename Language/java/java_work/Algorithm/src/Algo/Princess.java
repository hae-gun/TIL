package Algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Princess {
	

	static Flower[] flowers;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());

		flowers = new Flower[count];

		for (int i = 0; i < count; i++) {
			String tmp = br.readLine();
			String[] input = tmp.split(" ");
		
			flowers[i] = new Flower(input[0], input[1], input[2], input[3]);

		}

		Arrays.sort(flowers);
		String s = System.getProperty("server.upload.server.xmlPath");
		System.out.println(s);
		
		int endDay = 301;
		int idx = 0;
		int tmpEnd = 0;
		int num = 0;
		boolean flag;
		boolean resFlag = false;
		while (endDay < 1131 && idx < count) {
			flag = false;
			
//			System.out.println(idx);
			for (int i = idx ; i < count; i++) {
				if (flowers[i].start > endDay) {
					break;
				}
				if (tmpEnd < flowers[i].end) {
					flag = true;
					tmpEnd = flowers[i].end;
					idx = i;
				}
			}
			if (flag) {
				endDay = tmpEnd;
				num++;
			} else {
				resFlag = true;
				break;
			}
			idx++;
		}
		
		if (resFlag)
			num = 0;
		System.out.println(num);

	}

	

}
class Flower implements Comparable<Flower> {

	int start;
	int end;
	
	public Flower(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public Flower(String string1, String string2, String string3, String string4) {
		this.start = makeDay(string1,string2);
		this.end = makeDay(string3,string4);
	}

	int makeDay(String month, String day) {
		int result = Integer.parseInt(month) * 100 + Integer.parseInt(day);
		return result;
	}
	
	@Override
	public int compareTo(Flower f) {
		if (this.start > f.start) {
			return 1;
		} else if (this.start == f.start) {
			if (this.end > f.end) {
				return 1;
			}
		}
		return -1;
	}
}