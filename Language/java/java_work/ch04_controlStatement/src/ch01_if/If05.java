package ch01_if;

import java.util.Scanner;

public class If05 {
	public static void main(String[] args) {
		int score;
		String grade = "";
		Scanner sc = new Scanner(System.in);
		
		System.out.println("점수입력: ");
		score = sc.nextInt();
		
		//7보다 크면 +, 4보다 작으면 -, 둘다 아니면 0
		
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
		
		if(!grade.equals("F")) {
			int checkScore = score - (score/10*10);
			if(checkScore<4) {
				grade += "-";
			}else if(checkScore>7) {
				grade += "+";
			}else {
				grade +="0";
			}
		}
		
		
		System.out.printf("성적은 %d 점이고, 학점은 %s 입니다.",score,grade);
	}
}
