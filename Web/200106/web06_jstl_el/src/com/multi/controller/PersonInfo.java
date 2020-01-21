package com.multi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PersonInfo")
public class PersonInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		String name = request.getParameter("name");
		String adr = request.getParameter("adr");
		String phone = request.getParameter("phone");
		
		request.setAttribute("name", name);
		request.setAttribute("adr", adr);
		request.setAttribute("phone", phone);
		
		
		
		//3. 데이터 저장
		
		
		//4. 해당 view page 이동 : WebContent/view/~~~.jsp
		RequestDispatcher disp = request.getRequestDispatcher("/view/info.jsp");
		disp.forward(request, response);
	}

}


