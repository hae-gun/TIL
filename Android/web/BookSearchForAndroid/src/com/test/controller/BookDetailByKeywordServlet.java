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
 * Servlet implementation class BookDetailByKeywordServlet
 */
@WebServlet("/bookDetail")
public class BookDetailByKeywordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookDetailByKeywordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트가 보낸 값 받음
		String keyword = request.getParameter("keyword");
		// 로직처리 진행
		BookService service = new BookService();
		// 결과를 받아서 전달객체에 받음.
		ArrayList<BookVO> result = service.getBookDetail(keyword);
		// JSON 처리
		ObjectMapper mapper = new ObjectMapper();
		String jsonData = mapper.writeValueAsString(result);
		
		// 웹 화면에 표시 (Stream 이용)
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonData);
		out.flush();
		//자원반납
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
