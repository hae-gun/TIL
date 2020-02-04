package test;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class BoardlistController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 System.out.println("HelloController 실행중입니다.");
		  ModelAndView mv = new ModelAndView();
		  //board테이블 모든 게시물 : ArrayList<BoardVO>
		  //실행객체 생성.
		  BoardDAO dao = new BoardDAO();
		  ArrayList<BoardVO> list = dao.getList();
		  mv.addObject("boardlist", list); // request.setAttribute(list) 의 의미.
		  mv.setViewName("boardlist"); 
		  return mv; // DispatcherServlet이 받음.
	}

}
