package test;

import java.util.StringTokenizer;

public class Hash02 {

	public static void main(String[] args) {
		
		String[] phone_book =  {"123", "456", "789"};
		
		
		boolean answer = true;
        
        Loop: for(int i=0; i<phone_book.length-1;i++){
            for(int j=i+1; j<phone_book.length;j++){
                if(phone_book[i].startsWith(phone_book[j])){System.out.println(i+":"+j);answer= false; break Loop;}
                if(phone_book[j].startsWith(phone_book[i])){System.out.println(i+":"+j);answer= false; break Loop;}
            }
        }
        
        System.out.println(answer);

	}

}
