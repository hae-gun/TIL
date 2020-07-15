package com.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.service.BookService;
import com.test.vo.BookVO;

/**
 * Servlet implementation class BookInfoByKeywordServlet
 */
@WebServlet("/bookinfo")
public class BookInfoByKeywordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookInfoByKeywordServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 클라이언트가 보내주는 입력을 받는다.
		String keyword = request.getParameter("keyword");
		// 2. 로직처리를 진행. => Service 라고 불리는 로직처리 객체를 이용.
		BookService service = new BookService();
		//    로직처리 객체를 이용해서 일을 시킨다. => 특정 method를 호출.
		//	  검색어를 이용해서 책의 제목과 ISBN 번호를 알아오는 일을 시킨다.
		//    데이터 전달객체(VO, DTO)를 이용해야 데이터 전달이 편하다.
		ArrayList<BookVO> result = service.getBookInfo(keyword);
		// 3. 결과를 얻어온 후 
		//    결과 데이터를 JSON으로 만들어야 한다.
		//    JSON 문자열을 만들어서 Android App 에게 Stream 을 이용하여 출력.
		ObjectMapper mapper = new ObjectMapper();
		// ArrayList 형태의 데이터를 String 배열형태의 JSON으로 변환.
		String jsonData = mapper.writeValueAsString(result);
		
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonData);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
