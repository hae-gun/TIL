package aopexam;

import org.aspectj.lang.ProceedingJoinPoint;

public class AnimalAspect {

	public void result(ProceedingJoinPoint jp) {
		Object returnValue;
		try {
			System.out.println("¿À´Ã Á¡½É¿¡ ¹¹ ¸Ô¾ú¾î¿ä?");
			returnValue = jp.proceed();
			System.out.println(returnValue + " ¸Ô¾ú±º¿ä.");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void before() {
		System.out.println("¿À´Ã Á¡½É¿¡ ¹¹ ¸Ô¾ú¾î¿ä?");
	}

	public void after(Object ret) { // <aop:after-returning>À» »ç¿ëÇØ¾ßÇÔ. inputÀ» object·Î ÁÙ°Í.

		System.out.println(ret + " ¸Ô¾ú±º¿ä.");
	}

}
