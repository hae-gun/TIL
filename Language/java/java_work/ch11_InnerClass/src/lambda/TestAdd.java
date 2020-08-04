package lambda;

public class TestAdd {

	public static void main(String[] args) {

		
		Add add = new Add() {
			
			@Override
			public int add(int x, int y) {
				// TODO Auto-generated method stub
				return x+y;
			}
		};
		
		System.out.println(add.add(3,5));
		
		// Lambda 축약. '->'
		// FunctionalInterface 에서만 Lambda 사용가능.
		Add addF = (x, y) -> x + y;

		
		
		System.out.println(addF.add(3,5));
	}

}
