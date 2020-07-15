package tvspring;

//모든 TV들은 메소드 선언 일치 약속. 공통 약속: 구현방법은 다르다.
// 상속 받은 다른 클래스 "의무적" 메소드 OVERRIDING
public interface TV {

	public void powerOn();

	public void powerOff();

	public void soundUp();

	public void soundDown();

}
