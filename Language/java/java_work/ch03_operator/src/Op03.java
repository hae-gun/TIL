public class Op03 {
	public static void main(String[] args) {
		
		// 논리 연산자: boolean 반환
		// &&(and), ||(or), !(not), ^(xor)
		
		int n1 = 10, n2 = 4, n3 = 7, n4 = 15;
		// && 연산자
		
		// &&: 좌항, 우항이 모두 참일 경우에만 참
		// ||: 좌항, 우항 중 어느 한쪽이라도 참이면 참
		
		// &&는 회로상 직렬회로.
		System.out.println(n1 > n2 && n3 < n4); // true && true => true
		System.out.println(n1 > n2 && n3 > n4); // true && false => false
		System.out.println(n1 < n2 && n3 < n4); // false && true => false
		System.out.println(n1 < n2 && n3 > n4); // false && false => false
		System.out.println("------------------------");
		
		// ||는 회로상 병렬회로
		System.out.println(n1 > n2 || n3 < n4); // true || true => true
		System.out.println(n1 > n2 || n3 > n4); // true || false => true
		System.out.println(n1 < n2 || n3 < n4); // false || true => true
		System.out.println(n1 < n2 || n3 > n4); // false || false => false
		System.out.println("------------------------");
		
		// ^ : 좌항 우항의 값이 같으면 flase 다르면 true
		System.out.println(n1 > n2 ^ n3 < n4); // true ^ true => false
		System.out.println(n1 > n2 ^ n3 > n4); // true ^ false => true
		System.out.println(n1 < n2 ^ n3 < n4); // false ^ true => true
		System.out.println(n1 < n2 ^ n3 > n4); // false ^ false => false
		System.out.println("------------------------");
		
		// ! : 우항의 반대값(boolean) 반환
		System.out.printf("!%b = %b\n",true,!true);
		System.out.printf("!%b = %b\n",false,!false);
		
		// 작성할 때 먼저 확인하고 싶은것이 앞에 나와야 한다.
		// && 연산은 좌항값이 false 이면 뒤값을 보지 않는다.
		// || 연산은 좌항값이 true 이면 뒤값을 보지 않는다.
	}
}
