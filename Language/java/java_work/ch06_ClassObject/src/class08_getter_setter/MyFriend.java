package class08_getter_setter;

// DTO : Data Transfer Object (VO: Value Object), Domain
// encapsulation (정보 은닉)
class Friend {

	private String name;
	private int age;

	public Friend(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age >= 10) {
			this.age = age;
		} else {
			System.out.println("10살 이상만 친구가능.");
		}
	}

	@Override
	public String toString() {
		return "Friend [name=" + name + ", age=" + age + "]";
	}

}

public class MyFriend {

	public static void main(String[] args) {

//		Friend fr = new Friend();
//		fr.name = "이순신";
//		System.out.println(fr.name);

		Friend fr = new Friend("이순신");
		System.out.println(fr.getName());
		System.out.println(fr);

		fr.setAge(10);
		System.out.println(fr.getAge());

		celebrateBirthday(fr);
		System.out.println(fr.getAge());
		System.out.println("-----------------------");
		Friend chk = new Friend("최혜근");
		System.out.println(chk.getName());
		chk.setAge(27);
		System.out.println(chk.getAge());
		celebrateBirthday(chk);
		System.out.println(chk.getAge());
		

	}

	private static void celebrateBirthday(Friend fr) {
		System.out.println("생축");
		fr.setAge(fr.getAge() + 1);
	}

}
