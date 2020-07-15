package di;

public class MainEntry {

	public static void main(String[] args) { // 시작점(진입점)
		System.out.println("main method call!");
		show();
		MessageBean bean = new MessageBean();
		bean.sayHell("최혜근");
	}
	public static void show() {
		System.out.println("show method call");
	}
	

}
