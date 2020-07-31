package class08_getter_setter;

public class PersonEx {
	public static void main(String[] args) {
		Person ps = new Person();
		ps.setName("tom");
		
		System.out.println(ps.getName());
		
		Person ps1 = new Person("sam","1234",29);
		Person ps2 = new Person("jane","1157",44);
		
		Person[] persons = {ps1,ps2,ps};
		
		for(Person p : persons) {
			System.out.println(p);
			System.out.println("---------------------------------------");
		}
		
	}
}
