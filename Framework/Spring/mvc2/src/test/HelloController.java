package test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Command 패턴 사용함.(Interface Orverriding)
public class HelloController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("HelloController 실행중입니다.");
		
		// servlet ---> jsp 데이터 전달, 공유
		request.setAttribute("model", "Hello Spring"); //(or session.setAtrribute) (이름, 값) "model"이라는 값을 전달받을 예정
		return "/hello.jsp";/* 사용할 view의 이름을 리턴*/
		//받을때 --> request.getAttribute("model");
		//or ${model}
	}

}
