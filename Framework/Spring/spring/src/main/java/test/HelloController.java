package test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {

	@Override 
	  public ModelAndView handleRequest(HttpServletRequest request,
	  HttpServletResponse response) {
	  System.out.println("HelloController 실행중입니다.");
	  ModelAndView mv = new ModelAndView();
	  //Controller ---> jsp 데이터 전달 = 공유 = Model(뷰에 보여줄 데이터) : 용어
	  mv.addObject("model", "Hello Spring"); // Model Setting
	  mv.setViewName("hello"); // View Setting (확장자 빼고 작성.)
	  return mv; 
	}

}
