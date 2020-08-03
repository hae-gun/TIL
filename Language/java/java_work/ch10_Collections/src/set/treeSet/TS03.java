package set.treeSet;

import java.util.Set;
import java.util.TreeSet;

public class TS03 {
	public static void main(String[] args) {

		Set<Integer> lotto = new TreeSet<Integer>();

		
		long start = System.nanoTime();
		while (lotto.size() < 6) {

			lotto.add((int) (Math.random() * 45) + 1);

		}
		long end = System.nanoTime();

		System.out.println("Lotto number: "+lotto + ">>>>"+(end-start));
		
		start = System.nanoTime();
		
		lotto.clear();
		
		for(int i=0; lotto.size()<6;i++) {
			
			lotto.add((int) (Math.random() * 45) + 1);
			
		}
		end = System.nanoTime();
		System.out.println("Lotto number: "+lotto + ">>>>"+(end-start));

	}
}
