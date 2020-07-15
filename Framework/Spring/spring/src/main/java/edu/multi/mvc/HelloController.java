package edu.multi.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	 @RequestMapping("/hello") //xml 에서 <beans:prop key="/hello">hc</beans:prop> 의미.
	  public ModelAndView handleRequest(HttpServletRequest request,
	  HttpServletResponse response) {
	  System.out.println("HelloController 실행중입니다.");
	  ModelAndView mv = new ModelAndView();
	  mv.addObject("model", "Hello Spring Annotation"); 
	  mv.setViewName("hello"); //없어도 view가 셋팅이됨. 명시가 없으면 url과 똑같은 view를 지정함.
	  return mv; 
	}

}
