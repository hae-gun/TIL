package class04_static;

public class Accumulator {

	int total; // instance 변수, 자동초기화
	static int grandTotal; // 클래스 변수, 객체들의 공유 공간.
	
	public Accumulator() {
		grandTotal += 10;
	}
	void accumulator(int num) {
		total += num;
		grandTotal += num;
	}
}
