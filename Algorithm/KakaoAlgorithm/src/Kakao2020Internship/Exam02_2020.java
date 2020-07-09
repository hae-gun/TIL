package Kakao2020Internship;

import java.util.LinkedList;

public class Exam02_2020 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "100-200*300-500+20";
		String exec = s;
		
		String[] number = s.split("[^0-9]");
		StringBuilder sb = new StringBuilder(s);
		for(String del:number) {
			exec = exec.replace(del, " ").trim();
		}
		for(String ss : number) {
			System.out.println(ss);
		}
		String[] execset = exec.split(" ");
		for(String ss : execset) {
			System.out.println(ss);
		}
	}
	
	public static long solution(String expression) {
        long answer = 0;
        LinkedList<Integer> calcNum = new LinkedList<Integer>();
        String[] number = expression.split("[^0-9]");
        
        for(String numSet : number) {
        	calcNum.addLast(Integer.valueOf(numSet));
        }
        
        StringBuilder sb = new StringBuilder(expression);
        String temp = expression;
        
        for(String del:number) {
        	temp = temp.replace(del, " ").trim();
		}
        
        
        
        return answer;
    }

}
