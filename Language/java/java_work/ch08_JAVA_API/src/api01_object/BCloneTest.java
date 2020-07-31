package api01_object;

public class BCloneTest {
	public static void main(String[] args) {
		B a1, a2 = null;
		a1 = new B(10, new int[] { 10, 20, 30 });
		
		try {
			a2 = (B)a1.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		System.out.println("-------------");
		System.out.println(a1.hashCode());
		System.out.println(a2.hashCode()); 
		// 해시코드가 서로 다름 //서로 다른 객체라는 뜻 
		a1.i=99; //원본의 값이 바뀌어도 
		a1.arr[0]=99;	
		System.out.println("a1.i= "+a1.i); 
		System.out.println("a2.i= "+a2.i); 
		//복제본의 값에는 영향을 미치지 않지만 
		System.out.println("a1.arr[0]="+a1.arr[0]);	//99 
		System.out.println("a2.arr[0]= "+a2.arr[0]); //99 참조형
		// 필드는 '번지만 복제'되기 때문에 같은 객체를 참조하게 된다 (얕은 복제) }
	}
}
