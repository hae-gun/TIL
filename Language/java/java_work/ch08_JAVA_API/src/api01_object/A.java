package api01_object;

public class A {
	int i;
	int[] arr;
	public A(int i, int[] arr) {
		this.i = i;
		this.arr = arr;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
}
