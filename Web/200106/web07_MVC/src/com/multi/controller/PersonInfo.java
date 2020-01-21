package com.multi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PersonInfo
 */
@WebServlet("/PersonInfo")
public class PersonInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
				
		Person person = new Person(name, address, phone);
		
		request.setAttribute("person1", person);
		
		RequestDispatcher dispathcer = request.getRequestDispatcher("/view/info.jsp");
		dispathcer.forward(request, response);
		
	}
	
	class Person{
		
		String name;
		String address;
		String phone;
		
		public Person(String name, String address, String phone) {
			super();
			this.name = name;
			this.address = address;
			this.phone = phone;
		}

		@Override
		public String toString() {
			return "이름은 " + name + ", 주소는 " + address + ", 핸드폰 번호는 " + phone;
		}
		
		
		
	}

}
