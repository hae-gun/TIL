package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontControllerServlet extends HttpServlet {
	// web.xml:'/' -> FrontControllerServlet
	// 모든 요청 FrontControllerServlet
	/* @WebServlet("/front") */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1> FrontControllerservlet</h1>"); // FrontController패턴 : 모든 요청을 하나의 Controller로 제어하기 위한 패턴.
															// Spring에서 사용하는 패턴.
		out.println(request.getRequestURL());
		out.println(request.getRequestURI());
		String s[] = request.getRequestURI().split("/");
		out.println("<h1>" + s[s.length - 1] + "</h1>");
		// 3. hello - 일 시키자( MVC ) --> SPRING 내부환경 이해 로직.
		HandlerMapping mapping = new HandlerMapping();
		Controller controller = mapping.getController(s[s.length - 1]);
		String viewname = controller.handleRequest(request, response); // model이름으로 "Hello Spring" 문자열을 만들어서 hello.jsp 를 리턴해줌
		
		RequestDispatcher rd = request.getRequestDispatcher(viewname);
		rd.forward(request, response);//(요청변수, 응답변수)
	}

}
