package aopexam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnimalMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("aopexam/animal.xml");
		
		Animal [] ani = new Animal[3]; //인터페이스로 배열 생성은 가능.
//		Animal ani = new Animal(); 인터페이스로 객체생성은 불가능.
		ani[0] = (Animal)factory.getBean("cat");
		ani[1] = factory.getBean("dog", Animal.class);
		ani[2] = factory.getBean("rabbit", Animal.class);
		
		for(Animal A: ani) {
			A.lunch();
		}
	}

}


/*오늘 점심에 뭐 먹었어요?
 * 생선을 먹었습니다.
 * 냥이-생선 먹었군요.
/*오늘 점심에 뭐 먹었어요?
사료를 먹었습니다.
 * 강아지-사료 먹었군요.
/*오늘 점심에 뭐 먹었어요?
당근을 먹었습니다. 와 같은 결과 나오도록 만들기.
 * 토끼-당근 먹었군요.
 * */
 