package edu.multi.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@RequestMapping(name = "/login", method = RequestMethod.GET)
	public String loginform() { // 1. 매핑 메소드 리턴타입이 String일때 : 자동으로 View의 이름이 됨. 모델없이 뷰만 필요할때 사용함.
		// 로그인폼 출력=html태그=jsp
		// model, view 가 필요하나 여기선 model이 필요없음. view만 만들면됨.

		return "loginform";
	}

	// <form action="" method=POST>
	// 폼 입력 내용 전달받아서 처리.
	// 요청방식 post : 한글 깨져서 나옴.
//	@RequestMapping(name = "/login", method = RequestMethod.POST)
//	public ModelAndView loginsuccess(HttpServletRequest request) {//parameter를 읽을때 Request변수 필요함. Servlet요청
//	 request.setCharacterEncoding("UTF-8"); // 이미 xml로 작성했다.
//		try {
//			request.setCharacterEncoding("UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		// id pw 입력 전달 상태
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//
//		// id, pw - db member테이블 에서 조사.
//		// id spring 이고 pw spring 일 때만 로그인상태 : true
//		ModelAndView mv = new ModelAndView();
//
//		if (id.equalsIgnoreCase("spring") && pw.equalsIgnoreCase("spring")) {
//			mv.addObject("loginresult", true);
//		} else {
//			mv.addObject("loginresult", false);
//		}
//
//		mv.setViewName("loginsuccess");
//		return mv;
//	}
//	@RequestMapping(name = "/login", method = RequestMethod.POST)
//	public ModelAndView loginsuccess(@RequestParam(value="id",required = true, defaultValue="spring")
//	String id2, String pw, int age) { //id2 변수 요청파라미터 id 자동저장.
//		
//// 		form input name="id" : 클라이언트가 요청파라미터 이름 id를 전송한다.
//// 		요청파라미터이름과 컨트롤러 메소드 매개변수 이름이 동일하면 자동으로 저장함.		
////		form 입력 name 값 = 매개변수 이름 동일 => db 컬럼명 동일 저장. 3개를 맞추는것을 권장.
//		ModelAndView mv = new ModelAndView();
//
//		if (id2.equalsIgnoreCase("spring") && pw.equalsIgnoreCase("spring")) {
//			mv.addObject("loginresult", true);
//		} else {
//			mv.addObject("loginresult", false);
//		}
//
//		mv.setViewName("loginsuccess");
//		return mv;
//	}
	@RequestMapping(name = "/login", method = RequestMethod.POST)
	public ModelAndView loginsuccess(@ModelAttribute("login") LoginVO vo) { 
		
		//요청파라미터이름과 컨트롤러 메소드 매개변수 자바객체일때.
		//객체 내부 멤버변수들 이름 동일 자동 저장.
		//get메서드 사용.
//		컨트롤러 메소드 매게변수 객체일 때 자동 모델형태로 사용됨.
//		 모델 이름("",???) 모델 이름은 자동으로 결정됨. : LoginVO -> loginVO로 생성. (맨 앞글자 대문자를 소문자로 바꾼.)\
//		 mv.addObject("loginVO", vo);와 같은 의미.
		ModelAndView mv = new ModelAndView();
		
		if (vo.getId().equalsIgnoreCase("spring") && vo.getPw().equalsIgnoreCase("spring")) {
			mv.addObject("loginresult", true);
		} else {
			mv.addObject("loginresult", false);
		}
		
		mv.setViewName("loginsuccess");
		return mv;
	}

}
