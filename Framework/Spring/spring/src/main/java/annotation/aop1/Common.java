package annotation.aop1;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component // <bean id="common" class="Common">
@Aspect // <aop:aspect id="c" ref="common">
public class Common {
	
	@Pointcut("execution (public * annotation.aop1.*.*(..))") //<aop:pointcut expression="public * aop1.*.*(..))" id="pc">
	public void pc() { } //내용이 아무것도 없어야함. abstract 매서드가 아님. 
	
	long startTime = System.currentTimeMillis(); // 현재 시각(1/1000초 리턴)
	
	//@Before("pc()") //<aop:before method="a" pointcut-ref="pc"/>
	public void a() { //before
		System.out.println("===매서드 호출시각===" + new Date(startTime));
	}
	
	//@After("pc()")
	public void b() { //after
		long endTime = System.currentTimeMillis(); 
		System.out.println("===메소드실행소요시간(1/1000)===" + (endTime - startTime));
	}
	
	@Around("pc()")
	public void c(ProceedingJoinPoint joinpoint) { //around : before + after
		try {
			System.out.println("메소드수행이전");
			Object returnvalue = joinpoint.proceed(); // pointcut 문법 선택 핵심관심 메소드 수행.
			System.out.println("리턴값= "+returnvalue);
			
			System.out.println(""+joinpoint.getTarget());
			System.out.println(""+joinpoint.getArgs());
			System.out.println(""+joinpoint.toLongString());
			
			System.out.println("메소드수행이후");
		} catch (Throwable e) {
			e.printStackTrace();
			}
		
	}
}
