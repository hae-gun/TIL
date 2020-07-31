package abstract01;

public abstract class Shape {
	public Shape() {
		System.out.println("부모");
	}
	// 일반 메서드 : 필요할 때만 재정의
	void title() {
		System.out.println("도형 그리기");
	}
	
	abstract void draw();
	abstract void delete();
	
}

class Circle extends Shape{
	public Circle() {
		System.out.println("자식 Circle 생성자");
	}
	
	
	@Override
	void draw() {
		// TODO Auto-generated method stub
		System.out.println("원 그리기");
	}
	
	@Override
	void delete() {
		// TODO Auto-generated method stub
		System.out.println("원 지우기");
		
	}
}

class Triangle extends Shape{
	public Triangle() {
		System.out.println("자식 Triangle 생성자");
	}
	
	
	@Override
	void draw() {
		// TODO Auto-generated method stub
		System.out.println("삼각형 그리기");
	}
	
	@Override
	void delete() {
		// TODO Auto-generated method stub
		System.out.println("삼각형 지우기");
		
	}
}



