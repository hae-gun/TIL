package api01_object;

public class B implements Cloneable {
	int i;
	int[] arr;

	B(int i) {
		this.i = i;
	}

	B(int i, int[] arr) {
		this(i);
		this.arr = arr;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		B copyObj = (B) super.clone(); 
		// arr.clone(); 
		int[]copyArr = (int[])arr.clone(); 
		copyObj.arr = copyArr;

		return copyObj;
	}
}
