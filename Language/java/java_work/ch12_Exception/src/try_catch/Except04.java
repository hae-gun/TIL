package try_catch;

public class Except04 {
	public static void main(String[] args) {

		// 자기가 호출한 메서드에서 Exception을 던지면 받아서 처리해야함.
		// 받은 Exception을 또 던지면 명시적으로 처리할 수 없다.
		try {
			System.out.println(findClass().getClass().getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private static Object findClass() throws ClassNotFoundException {
		// String str = new String();

		// 발생가능한 ClassNotFoundException 을 호출한 쪽으로 던진다.
		Class cls = Class.forName("java.lang.String");

		return cls;
	}
}
