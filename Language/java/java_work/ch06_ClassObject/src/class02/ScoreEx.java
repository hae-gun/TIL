package class02;

public class ScoreEx {
	public static void main(String[] args) {
		
		Score s1 = new Score();
		Score s2 = new Score(87);
		Score s3 = new Score(93,"aaa");
		Score s4 = new Score("bbb",88);
		Score s5 = new Score(80,100);
		
		s2.dispaly();
		s3.dispaly("김개똥");
		
	}
}
