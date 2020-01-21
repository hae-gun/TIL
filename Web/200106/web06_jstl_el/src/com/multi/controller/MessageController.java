package com.multi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mc")
public class MessageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//1. 전송방식 결정 ,사용자 요청 분석(doGet/doPost)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	//2. 사용자 요청 처리 메세지(doGet / doPost 방식)
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String msg = request.getParameter("message");
		Object result =null;
		
		if(msg == null||msg.equals("test")){
			result = "메세지가 없거나, test로 넘어옴. ";
		}else if(msg.equals("name")){
			result = "내 이름은 kinsmile.";
		}else {
			result = "찾는 type이 없음.";
		}// if end
		
		//3. 데이터 저장
		request.setAttribute("result", result); // spring도 유사함.
		
		//4. 해당 view page 이동 : WebContent/view/~~~.jsp
		RequestDispatcher disp = request.getRequestDispatcher("/view/msgView.jsp");
		disp.forward(request, response);
	}

}
