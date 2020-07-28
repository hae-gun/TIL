package lotto;

public class Test {

	public static void main(String[] args) {
		TestIns testIns = new TestIns(10, 20);
		System.out.println(testIns.hashCode());
		testIns.setTest(testIns);
		System.out.println(testIns.hashCode());
		System.out.println(testIns);
	}
}

class TestIns {
	public int x;
	public int y;

	public TestIns(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setTest(TestIns testIns) {
		testIns = new TestIns(30, 40);
		System.out.println(testIns.hashCode());
		System.out.println(this.hashCode());
	}

	@Override
	public String toString() {

		return "x : " + x + ", y :" + y;
	}
}