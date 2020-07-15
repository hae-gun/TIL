package annotation.aopexam;

import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal {

	@Override
	public String lunch() {
		System.out.println("사료를 먹었습니다.");
		return "강아지-사료";
	}

}
