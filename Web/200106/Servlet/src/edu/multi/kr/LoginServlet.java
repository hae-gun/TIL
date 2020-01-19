package edu.multi.kr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("EUC-KR");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		System.out.println(id + "," +pwd);
		PrintWriter pw = response.getWriter();
		
		pw.write("<html><head><title>ID확인</title></head>");
		pw.write("<body><h1>정보.</h1><hr>");
		pw.write("<h2>ID :");
		pw.write(id);
		pw.write("<br>pw :");
		pw.write(pwd);
		pw.write(" 입니다.</h2>");
		pw.write("<a href='html/loginForm.html'>Login</a>");
		pw.write("</body></html>");
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
