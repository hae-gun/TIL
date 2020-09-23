package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sec02.ex01.MemberBean;
import sec02.ex01.MemberDAO;

@WebServlet("/memberAction")
public class Controller extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id"); // form 에서 작성하여 보내준 값을 변수에 받아둠.
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
 
		MemberBean m = new MemberBean(id, pwd, name, email);

		MemberDAO memDAO = new MemberDAO();
		memDAO.addMember(m);
		List membersList = memDAO.listMembers();
		request.setAttribute("membersList", membersList);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("test06/membersList.jsp");
		dispatch.forward(request, response);

	}

}
