package com.spring.ex01;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor {
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		// aop -> 보안, 로그인 데이터 분석에 사용한다.
		
		System.out.println("[Before : LogginAdvice");
		System.out.println(invocation.getMethod() + " Befor");
		
		// 실제 객체의 매서드가 실행되는 것. => Calculator 의 메서드들.
		Object object = invocation.proceed();

		System.out.println("[After : loggingAdvice");
		System.out.println(invocation.getMethod() + " After");
		return object;
	}
}
