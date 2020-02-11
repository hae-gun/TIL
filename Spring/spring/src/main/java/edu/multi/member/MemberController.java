package edu.multi.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	//회원가입기능. 알아서 작성
	@Autowired
	MemberDAO dao;
	//로그인기능.
	
		@RequestMapping(value = "/session/insertmember", method=RequestMethod.GET)
		public String insertform() {
			return "mybatis/insertmember";
		}
		
		@RequestMapping(value = "/session/insertmember", method=RequestMethod.POST)
		public String insertprocess(MemberVO vo) {
			
			if(dao.checkMember(vo)==null) {
				dao.insertMember(vo);
				return "mybatis/successinsert";
				}
			else
				return "mybatis/inserterror";
			
			
		}
		
	
		@RequestMapping("/session/login")
		public String loginform() {
			return "mybatis/login"; //로그인 폼 보여주는 창.
		}
		@RequestMapping("/session/loginprocess")//db member 테이블 존재 - 세션 존재.
		public String loginprocess(HttpServletRequest request, String userid, String password) { //로그인 폼에서 입력받은 데이터 처리
			//ModelAndView mv = new ModelAndView();
			MemberVO vo = dao.selectMember(userid,password);
			//mv.addObject("member",vo);//1개 뷰 (mvc)
			//mv.setViewName("mybatis/loginprocess");
			HttpSession session = request.getSession();
			session.setAttribute("member", vo);
			return "mybatis/loginprocess";
		}
		@RequestMapping("/session/mypage")
		public String getMyPage() {
			// session을 통해 만들어진 모델은 위에서 생성된 모델이며 브라우저가 종료되지 않는 한 계속 사용이 가능하다.
			return 	"mybatis/mypage";
		}
		@RequestMapping("/session/logout")
		public String logout(HttpSession session) {
			//새션정보 지우기. HttpSession 객체 저장 정보 삭제.
			//HttpSession session = request.getSession();
			//session.removeAttribute("member");
			return "mybatis/logout";
		}
		
	//로그아웃기능.
}
