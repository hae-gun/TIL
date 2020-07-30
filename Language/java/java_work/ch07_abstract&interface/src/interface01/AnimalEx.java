package interface01;

public class AnimalEx {
	public static void main(String[] args) {
		// interface 는 객체생성 불가능
//		Animal ani = new Animal();
		Animal cat = new Cat("구름");
		Animal dog = new Dog("파랑");
		
		Animal[] ani = {cat,dog};
		for(Animal k: ani) {
			k.eat();
			k.sound();
			System.out.println("-----------------------");
		}
		
		Animal tiger = new Animal() {
			
			@Override
			public void sound() {
					System.out.println(OWNER+" 의 호랑이 등장");
			}
			
			@Override
			public void eat() {
				System.out.println(OWNER+" 의 호랑이 밥먹");
			}
		};
		
		tiger.sound();
		tiger.eat();
	}
}
