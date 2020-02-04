package edu.multi.mvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardlistController  {
	@Autowired// 1.<beans:bean id="dao" class="xxx.BoardDAO.class"> 2. @Repository("dao") class BoardDAO
	BoardDAO dao;
	
	@RequestMapping("/boardlist")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 System.out.println("HelloController 실행중입니다.");
		  ModelAndView mv = new ModelAndView();
		/* BoardDAO dao = new BoardDAO(); */ 
		  ArrayList<BoardVO> list = dao.getList();
		  mv.addObject("list", list); 
		  mv.setViewName("boardlist"); 
		  return mv; 
	}

}
