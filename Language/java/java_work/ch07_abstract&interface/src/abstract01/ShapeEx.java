package abstract01;

public class ShapeEx {
	public static void main(String[] args) {
		Shape cc = new Circle();
		Shape ta = new Triangle();
		
		Shape[] shArr = {cc,ta};
		for(Shape sh : shArr) {
			sh.title();
			sh.draw();
			sh.delete();
		}
	}
}
