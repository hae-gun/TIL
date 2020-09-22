package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login") 
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// Post 와 같은 방식으로 동작할시에는 아래 메서드 사용. 보통 이렇게 사용안함.
		//doHandle(request, response);
		//get 방식으로 접근시 다시 로그인 페이지로 화면 전환.
		response.sendRedirect("login3.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		doHandle(request, response);
	}
	// doGet 과 doPost가 같은 메서드로 동작하기 위
	private void doHandle(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); // 응답해주는 페이지 해더에 추가해줌.
		PrintWriter out = response.getWriter(); // response에 출력할 출력 객체를 가져옴.
		String user_id = request.getParameter("user_id"); // form 에서 작성하여 보내준 값을 변수에 받아둠.
		String user_pwd = request.getParameter("user_pwd");

		MemberVO memberVO = new MemberVO();
		memberVO.setId(user_id);
		memberVO.setPwd(user_pwd);
		MemberDAO dao = new MemberDAO();
		boolean result = dao.isExisted(memberVO);
		

		if (result) {
			HttpSession session = request.getSession();
			session.setAttribute("isLogon", true);
			session.setAttribute("login.id", user_id);
			session.setAttribute("login.pwd", user_pwd);

			out.print("<html><body>");
			out.print("안녕하세요 " + user_id + "님!!!<br>");
			out.print("<a href='show'>정보보기</a>");
			out.print("</body></html>");
		} else {
			out.print("<html><body>로그인 실패.");
			out.print("<a href='login3.html'> 다시로그인</a>");
			out.print("</body></html>");
		}
	}

}
