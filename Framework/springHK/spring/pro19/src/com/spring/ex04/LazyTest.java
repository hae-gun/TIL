package com.spring.ex04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class LazyTest {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("lazy.xml");
		System.out.println("SecondBean 출력");
		// secondBean 이 lazy-init true 로 설정되어 있어 context의 getBean을 이용하여 불러와준다.
		context.getBean("secondBean");
	}
}


