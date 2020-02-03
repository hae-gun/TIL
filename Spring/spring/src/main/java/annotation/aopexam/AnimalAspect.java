package annotation.aopexam;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AnimalAspect {

	@Pointcut("execution (public * annotation.aopexam.*.*(..))")
	public void pc() {
	}

	@Around("pc()")
	public Object result(ProceedingJoinPoint jp) { // Around 매서드에 return값을 주어 값을 받아올수 있음. 없으면 null로 return.
		Object returnValue=null;
		try {
			System.out.println("오늘 점심에 뭐 먹었어요?");
			returnValue = jp.proceed();
			System.out.println(returnValue + " 먹었군요.");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return returnValue;
		
	}
	//@Before("pc()")
	public void before() {
		System.out.println("오늘 점심에 뭐 먹었어요?");
	}
	//@AfterReturning("pc()") //Around와 AfterReturning 둘이 동시에 사용은 불가능하다.
	public void after(Object ret) { // <aop:after-returning>을 사용해야함. input을 object로 줄것.

		System.out.println(ret + " 먹었군요.");
	}
}
