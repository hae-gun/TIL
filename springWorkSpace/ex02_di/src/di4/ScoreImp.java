package di4;

public class ScoreImp implements Score {

	private int kor, eng, math;

	// constructor DI
	public ScoreImp(int kor, int eng, int math) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public ScoreImp() {
		this(0, 0, 0);
	}

	@Override
	public int total() {
		return this.kor + this.eng + this.math;
	}

	@Override
	public float avg() {
		return total() / 3.0f;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

}
