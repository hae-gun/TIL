package api02_String;

public class String03 {
	public static void main(String[] args) {
		
		String str1 = "We are the Champions!";
		String str2 = "I love You!, I love You!";
		
		for(int i=0; i<str1.length(); i+=2) {
			System.out.print(str1.charAt(i));
		}
		System.out.println();
		//문자열 거꾸로 출력
		for(int i=str1.length()-1;i>=0;i--) {
			System.out.print(str1.charAt(i));
		}
		System.out.println();
		
		for(int i=0; i<str1.length(); i++) { //문자열 암호화
			if(i%2==0)
				System.out.print(str1.charAt(i));
			else {
				System.out.print("*");
				System.out.print(str2.charAt(i));
			}
			}

	}
}
