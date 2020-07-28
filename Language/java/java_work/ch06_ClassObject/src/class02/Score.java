package class02;

// 생성자 overloading
public class Score {
	// field
	int kor;
	int eng;
	int math;
	String nick;

	public Score() {
	}

	public Score(int kor) {
		this.kor = kor;
	}
	// 갯수가 같아도 타입이 다르면 다른 매서드로 인식.
	public Score(String nick) {
		this.nick = nick;
	}
	
	public Score(int kor, int eng) {
		this.kor = kor;
		this.eng = eng;
	}
	
	// 매개변수의 내용이 같아도 타입의 순서가 다르면 다른 생성자이다.
	public Score(int kor, String nick) {
		this.kor = kor;
		this.nick = nick;
	}
	
	public Score(String nick,int kor) {
		this.kor = kor;
		this.nick = nick;
	}
	
	// 이름이 같아도 매개변수의 갯수와 타입이 다르면 다른 매서드로 간주한다.
	void dispaly() {
		System.out.printf("국어: %d,영어: %d,수학: %d\n",kor,eng,math);
	}
	
	void dispaly(String name) {
		System.out.printf("이름: %s, 국어: %d,영어: %d,수학: %d\n",name,kor,eng,math);
	}

}
