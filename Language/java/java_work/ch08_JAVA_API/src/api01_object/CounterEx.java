package api01_object;

public class CounterEx {
	public static void main(String[] args) {
		
		Counter counter = null;
		
		for(int i =0; i< 50; i++) {
			counter = new Counter(i);
			counter = null;
			System.gc();
		}
		counter = new Counter(333);
		System.out.println(Integer.toHexString(counter.hashCode()));
		System.out.println(counter);
		
	}
	
}
