package edu.multi.mvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController  {
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
	
////	1개 게시물 조회.
//	@RequestMapping("/boarddetail")
//	public ModelAndView boardDetail(@ModelAttribute("vo") BoardVO vo) {
//		ModelAndView mv = new ModelAndView();
//		dao.getDetail(vo.getSeq());
//		return mv;
//	} 
//	1갸 개시물 작성.
//	1개 게시물 글쓰기 폼 화면
	@RequestMapping(value = "/boardinsert", method=RequestMethod.GET)
	public String insertBoardForm() {
		return "boardinsertform";
	}
	//글쓴 내용전달받아서 board 테이블 저장.
	@RequestMapping(value = "/boardinsert", method=RequestMethod.POST)
	public String insertBoardResult(@ModelAttribute("vo")BoardVO vo) {
//		BoardDAo 객체 insertBoard(vo) 전달.
//		System.out.println(vo.getTitle());
		int result = dao.insertBoard(vo);
		if(result==1) {
			System.out.println("정상 insert");
		}else {
			System.out.println("비정상 insert");
		}
		return "redirect:/boardlist";
	}
	//1개 게시물 수정
	@RequestMapping(value="/boardupdate", method = RequestMethod.GET)
	public String updateBoardForm() {
		
		return "updateboardform";
	}
	@RequestMapping(value="/boardupdate", method = RequestMethod.POST)
	public String updateBoard() {
		
		return "redirect:/boardlist";
	}
	//1개 게시물 삭제
	@RequestMapping(value = "/boarddelete", method=RequestMethod.GET)
	public String deleteBoardForm() {
		return"deleteboardform";
	}
	@RequestMapping(value = "/boarddelete", method=RequestMethod.POST)
	public String deleteBoard(int seq) {
		System.out.println("deleteBoard 실행중입니다.");
		int result = dao.deleteBoard(seq);
		if(result==1) {
			System.out.println("정상 delete");
		}else {
			System.out.println("비정상 delete");
		}
		return "redirect:/boardlist";
	}
	
	
}
