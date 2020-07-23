package cs01_if;

public class if03 {
	public static void main(String[] args) {
		// random 으로 점수 (score) 를 받아서 학점처리
		// 0~59 : F / 60~69: D / 70~79 : C / 80~89 : B / 90~100: A
		int score;
		String grade = "";
		
		score = (int)(Math.random()*100)+1;
		
		
		if(score>=0&&score<=59) {
			grade = "F";
		}else if(score>=60&&score<=69){
			grade = "D";
		}else if(score>=70&&score<=79){
			grade = "C";
		}else if(score>=80&&score<=89){
			grade = "B";
		}else if(score>=90&&score<=100){
			grade = "A";
		}
		
		
		System.out.printf("성적은 %d 점이고, 학점은 %s 입니다.",score,grade);
		
	}
}
