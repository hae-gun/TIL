package Synchro_Asynchro;

public class Reference {
	
	
	
	public static void main(String[] args) {
		Test test = new Test("Old");
		System.out.println(test);
		test.changeAddr(test);
		System.out.println(test);
		
		
		
	}
	
}

class Test{
	int addr = this.hashCode();
	String name;
	
	public Test(String name) {
		this.name = name;
	}
	
	
	public void changeAddr(Test test) {
		System.out.println(test);
		test = new Test("New");
		System.out.println(test);
	}


	public int getAddr() {
		return addr;
	}


	public void setAddr(int addr) {
		this.addr = addr;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Test [addr=" + addr + ", name=" + name + "]";
	}
	
	
	
	
}
