package edu.multi.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@RequestMapping(name = "/login", method = RequestMethod.GET)
	public String loginform() { // 1. 매핑 메소드 리턴타입이 String일때 : 자동으로 View의 이름이 됨. 모델없이 뷰만 필요할때 사용함.
		// 로그인폼 출력=html태그=jsp
		// model, view 가 필요하나 여기선 model이 필요없음. view만 만들면됨.

		return "loginform";
	}

	@RequestMapping(name = "/login", method = RequestMethod.POST)
	public ModelAndView loginsuccess(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("loginresult",true);
		mv.setViewName("loginsuccess");
		return mv;
	}
}
