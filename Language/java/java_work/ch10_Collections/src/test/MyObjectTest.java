package test;

public class MyObjectTest {
	
	public static void main(String[] args) {
		myObject obj1 = new myObject(1,"first");
		myObject obj2 = new myObject(1,"first");
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		
		System.out.println(obj1.equals(obj2));
		
		
	
	}
	
	
}




class myObject{
	
	int number;
	String name;
	
	public myObject(int number, String name) {
		this.number = number;
		this.name = name;
	}

	@Override
	public String toString() {
		return "myObject [number=" + number + ", name=" + name + "]";
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return number;
	}
	
//	@Override
//	public boolean equals(Object obj) {
//		// TODO Auto-generated method stub
//		return super.equals(obj);
//	}
	
	
}