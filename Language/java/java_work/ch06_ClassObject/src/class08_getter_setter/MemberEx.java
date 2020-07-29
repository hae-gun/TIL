package class08_getter_setter;

import java.util.Scanner;

public class MemberEx {
	public static void main(String[] args) {

		MemberService ms = new MemberService();

		Scanner sc = new Scanner(System.in);

		String name;
		int age;
		String id;
		String pwd;
		Member mem;
		Loop: while (true) {

			System.out.println("---------------------------------------------------------------------------");
			System.out.println("Register(1) | Login(2) | Logout(3) | MemberList(4) | guguPrint(5) | Quit(6)");
			System.out.println("---------------------------------------------------------------------------");
			
			int service = Integer.parseInt(sc.nextLine());
			
			switch (service) {
			case 1:

				System.out.println("name>>");
				name = sc.nextLine();
				System.out.println("age>>");
				age = Integer.parseInt(sc.nextLine());
				System.out.println("id>>");
				id = sc.nextLine();
				System.out.println("pwd>>");
				pwd = sc.nextLine();
				mem = ms.regist(name, age, id, pwd);
				if (mem != null) { // null check
					System.out.println("가입 성공");
					System.out.println(mem);
				} else {
					System.out.println("가입 실패");
				}
				break;
			case 2:
				System.out.println("id>>");
				id = sc.nextLine();
				System.out.println("pwd>>");
				pwd = sc.nextLine();
				if (ms.login(id, pwd) == 1) {
					System.out.println("login success");
				} else {
					System.out.println("id or pwd is wrong");
				}
				
				break;
			case 3:
				System.out.println("id>>");
				id = sc.nextLine();
				System.out.println(ms.logout(id));
				break;
			case 4:
				ms.listMember();
				break;
			case 5:
				System.out.println("id>>");
				id = sc.nextLine();
				ms.guguPrint(id);
				break;
			case 6:
				System.out.println("종료 하시겠습니까? y / n");
				String sel = sc.nextLine();
				if (sel.toLowerCase().trim().equals("y")) {
					System.out.println("bye have fun!");
//					System.exit(0);
					break Loop;
				}
				break;
			default:
				System.out.println("잘못된 입력");
				break;
			}
		}
		sc.close();

	}
}
