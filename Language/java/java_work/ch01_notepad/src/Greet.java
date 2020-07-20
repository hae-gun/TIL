// public 클래스는 파일에 하나만 있을 수 있다. 파일 이름과 같아야 한다.
public class Greet{
	// 메인 메소드 - 프로그램 시작점
	public static void main(String[] args){
		// 콘솔로 Say Hi~ 를 출력하라
		System.out.println("Say Hi~");
		// Hi라는 클래스를 사용하기 위해 하나 찍어냄. - 객체 생성
		Hi hi = new Hi();
		// . 은 앞에 들어있는것
		// 생성된 객체인 hi에 포함되어있는 메소드 print() 실행.
		hi.print();
		hi.print();
		hi.print();
	}
}

// 한 파일에 들어 있지만 컴파일 하면 클래스 파일은 분리됨.
class Hi{
	// print 메소드
	public void print(){
		System.out.println("Hi, I'm the King of JAVA~");
	}
}