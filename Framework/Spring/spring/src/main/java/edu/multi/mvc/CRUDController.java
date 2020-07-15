package edu.multi.mvc;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CRUDController {

	Map<String, String> members = new HashMap<String, String>();

//회원관리
	// http://ip:port/컨텍스트명/crud/start
	@RequestMapping("/crud/start")
	public void start() { // void일떄는 모델 전달할 것도 없다는 의미.
		// 명시적으로 뷰 이름을 명시하면 뷰 이름이 됨. 뷰 이름이 명시안되어 있다면 자동으로 url 이름과 동일하게 뷰를 만듬.
		System.out.println("====홈페이지 첫화면입니다.====");
		members.put("spring", "김사원");
		members.put("oracle", "이대리");
		members.put("mybatis", "최과장");
		// return "crud/start"; // view로 start.jsp를 줄것. 왼쪽같이 할때 : crud폴더안의 start.jsp로
		// 인식.
	}

	@RequestMapping("/crud/list")
	public ModelAndView list() {
		// 모든 회원정보
		// Model -- 컨트롤러에서 jsp 전달 출력 데이터.
		ModelAndView mv = new ModelAndView();
		mv.addObject("members", members);
		// 뷰 이름 지정안하면 자동으로 RequestMappling의 mapping url 과 같아짐.
		return mv;
	}

	@RequestMapping("/crud/get")
	public ModelAndView get(HttpServletRequest request) {
		String id = request.getParameter("id");
		String name = members.get(id);

		ModelAndView mv = new ModelAndView();
		mv.addObject("member", id + ":" + name);
		return mv;
	}

	@RequestMapping("/crud/add")
	public void add() {
		// "new" "신입사원" members추가. - crud/add.jsp
		members.put("new", "신입사원");
	}

	@RequestMapping("/crud/update")
	public Map<String, String> update() { //첫번째 스트링 : 모델이름, 두번째 스트링 : 모델값.
		Map<String, String> informs = new HashMap<String, String>();
		informs.put("id","수정할 id를 입력하세요");
		informs.put("name","수정할 이름를 입력하세요");
		informs.put("email","이메일 양식은 xxx@yyy.com 형식입니다.");
		informs.put("idvalue","spring");
		//${id}
		return informs; // 자동으로 3개의 모델만듬. 
		//view는 명시가 없으니 자동으로 url과 같아짐. .../crud/update.jsp
	}

	@RequestMapping("/crud/delete")
	public String delete() {
		// "new" 아이디 members에서 삭제.
		members.remove("new");
		return "redirect:/crud/list"; // redirect:컨트롤러 내부 list()메소드 수행후 그 매서드 결과 뷰로 바로이동하라는 의미.;

	}
//	 
}
