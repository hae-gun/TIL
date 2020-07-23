package cs02_sw;

public class Sw03 {

	public static void main(String[] args) {

		String level = "member";

		// switch를 이용한 권한부여
		switch (level) {
		case "admin":
			grantDelete();// break를 사용하지 않는다. 3개의 권한을 모두 갖게 하기위함.
		case "member":
			brantWrite();
		default:
			grantRead();
			break;
		}

	}

	private static void grantRead() {
		System.out.println("읽기가능");
	}

	private static void brantWrite() {
		System.out.println("쓰기가능");
	}

	private static void grantDelete() {
		System.out.println("삭제가능");
	}
}
