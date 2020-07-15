package javaIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Java IO ( 입력과 출력 )
 * Stream을 이용하여 처리한다.
 * Stream : Data를 받아들리고 보낼 수 있는 통로 
 * 우리 자바 프로그램이 표준출력(도스창)에 문자열을 출력하고 싶다면
 * 우리 자바프로그램과 연결된 도스창에 대한 Stream이 존재해야 한다.
 * 
 * Stream에 대해서 조금더 알아보면..
 * Stream은 객체로 존재한다. => class가 존재한다.
 * 이 class의 객체를 만들어서 method를 이용해서 데이터의 입출력을 수행한다.
 * 
 * Stream은 크게 2가지 종류가 있다. 입력스트림과 출력스트림.
 * 이 데이터 연결 통로는 단방향이다.
 * InputStream -> 가장 기본적인 입력 스트림.
 * OutputStream -> 가장 기본적인 출력 스트림.
 * => 이 두 종류의 Stream은 상당히 성능이 좋지않다.
 * 가장큰 이유는 속도가 느리다
 * Stream 은 결함해서 더 좋은 스트림으로 만들 수 있다.
 * 
 * 
 * */




public class Exam01_KeyboardInput {
	public static void main(String[] args) {
		System.out.println("Hello Java!");
		// System.out : 도스창(표준출력)에 연결된 우리에게 미리 제공된 Stream 이다.
		// Stream이 가지는 println() 이라는 method를 이용하여 실제 문자열을 도스창에 전달한것!
		
		// 도스창에서 문자열을 입력받고 싶다.
		// 기본적으로 InputStream이 있어야 받을 수 있다. 
		// System.in => 도스창과 연결된 InputStream.
		// InputStream은 효율도 좋지 않고 문자열을 읽어들이기에 좋지않다.
		// InputStream을 문자열 입력받기 좋은 InputStreamReader로 업그레이드.
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		try {
			String msg = br.readLine();
			System.out.println("입력받은 문자열은 : "+msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
