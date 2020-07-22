package ch01_if;

public class If02 {
	public static void main(String[] args) {
		// 주사위 굴려서 나온 값 출력

		// Math.random() : 0~ 0.999999999.. 중 하나 출력
		System.out.println((int)(Math.random()*10));
		
		// 0~6 랜덤수
		System.out.println((int)(Math.random()*6)+1);
		
		int num = (int)(Math.random()*6)+1;
		
		if(num==1) {
			System.out.println("1 나옴");
		}else if(num==2) {
			System.out.println("2 나옴");
		}else if(num==3) {
			System.out.println("3 나옴");
		}else if(num==4) {
			System.out.println("4 나옴");
		}else if(num==5) {
			System.out.println("5 나옴");
		}else if(num==6) {
			System.out.println("6 나옴");
		}
	}
}
