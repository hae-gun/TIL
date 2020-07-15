package di4;

import java.util.Scanner;

public class ScoreShowImp implements ScoreShow {

	private ScoreImp record;

	public ScoreShowImp() {} // action 생성자를 사용할떄 사용하기 때문에 작성해두는 것이 좋음.

	public ScoreShowImp(ScoreImp record) {
		this.record = record;
	}
	
	
	// DI
	public void setRecord(ScoreImp record) {
		this.record = record;
	}

	@Override
	public void print() {
		System.out.println("Kor = " + record.getKor());
		System.out.println("Eor = " + record.getEng());
		System.out.println("Math = " + record.getMath());
		System.out.println("Total = " + record.total());
		System.out.println("Avg = " + record.avg());
	}

	

	@Override
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Kro:");
		record.setKor(sc.nextInt());
		System.out.print("Eng:");
		record.setEng(sc.nextInt());
		System.out.print("Math:");
		record.setMath(sc.nextInt());
	}

}
