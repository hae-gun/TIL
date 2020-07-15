package com.multi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MessageCtrlEx01")
public class MessageCtrlEx01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String info_tag = request.getParameter("query_ex01");
		Object result_ex01 = null;
		if (info_tag == null) {
			result_ex01 = "isNull";
		} else if (info_tag.equals("Address")) {
			result_ex01 = "address_ex01";
		} else if (info_tag.equals("Contact") ) {
			result_ex01 = "contact_ex01";
		} else if (info_tag.equals("Name")){
			result_ex01 = "name_ex01";
		} else {
			result_ex01 = "NOTHING";
		}

		request.setAttribute("view_message_to_info_jsp", result_ex01);

		RequestDispatcher req_ex01 = request.getRequestDispatcher("/view/info1.jsp");
		req_ex01.forward(request, response);
	}

}
