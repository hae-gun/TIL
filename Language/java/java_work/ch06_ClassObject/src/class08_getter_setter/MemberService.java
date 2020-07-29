package class08_getter_setter;

public class MemberService {

	private Member[] mb = new Member[100];
	private int count = 0;

	public MemberService() {
		mb[count++] = new Member("aa", 11, "aa", "aa");
		mb[count++] = new Member("bb", 11, "bb", "bb");
		mb[count++] = new Member("cc", 11, "cc", "cc");
		mb[count++] = new Member("dd", 11, "dd", "dd");
	}

	public Member regist(String name, int age, String id, String pwd) {
		mb[count++] = new Member(name, age, id, pwd);
		return mb[count - 1];
	}

	public int login(String id, String pwd) {

		for (Member m : mb) {
			if (m != null && m.getId().equals(id) && m.getPwd().equals(pwd)) {
				if (!m.isLogin()) {
					m.setLogin();
					return 1;
				}
			}
		}
		return 0;
	}

	public String logout(String id) {
		for (Member m : mb) {
			if (m != null && m.getId().equals(id)) {
				m.setLogin();
				return "logout";
			}
		}
		return "로그아웃 실패";
	}

	public void listMember() {
		int num = 0;
		for (Member m : mb) {
			if (m != null) {
				System.out.println(m);
				num++;
			}
		}
		System.out.println("총 " + num + "명");
	}

	public void guguPrint(String id) {
		
		boolean check = false;
		
		for (Member m : mb) {
			if (m != null && m.getId().equals(id) ) {
				if (m.isLogin()) {
					gugudan();
					return;
				} else {
					System.out.println("로그인 해야합니다.");
					return;
				}
			}
		}
		
		System.out.println("없는 회원입니다.");
		

	}

	private void gugudan() {
		for (int i = 2; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.printf("%d*%d =%2d ", j, i, i * j);
			}
			System.out.println();
		}

	}

}
