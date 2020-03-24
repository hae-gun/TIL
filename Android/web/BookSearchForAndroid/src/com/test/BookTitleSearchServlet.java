
package com.test;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookTitleSearchServlet
 */
@WebServlet("/searchTitle")
public class BookTitleSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookTitleSearchServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// 입력, 로직, 출력의 코드가 하나의 method안에 옹기종기 모여있게 된다. => Model1 방식.
	// Model1 방식은 처음 작성하기에는 쉽고 빠른 방식이지만 추후에 유지보수가 안된다.
	// Medel1 방식에서 Medel2방식으로 전환. -> MVC pattern을 이용.
	// MVC Pattern을 이용하여 프로그램 분할.
	// - 1. Controller : 클라이언트가 보내주는 입력을 받고 처리된 최종 결과를 출력.
	// - 2. Service : 로직을 처리하는 역할.
	// - 3. DAO (Data Access Object) : 모든 Database의 처리. 
	// - 4. DTO (Data Transfer Object) : VO (Value Object), DO (Domain Object), Entity  
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get 방식으로 'Servlet' 이 호출되면 이 매서드가 호출된다.
		// 1. 입력받고 ( 입력을 받는 방식도 정해져있다.)
		// 2. 로직처리하고 ( 일반적인 로직처리 + DB처리 ) 
		// 3. 출력
		// 3-1. 클라이언트에 처리된 결과에 대한 종류, 인코딩에 대한 정보를 알려줘야함.
		// 일반 문자역이 결과로 출력되고 사용하는 인코딩은 유니코드임을 나타내줌.
		response.setContentType("text/plain; charset=utf-8");// MimeType
		// 3-2. 클라이언트에게 결과를 보내주기 위한 데이터 통로를 열어야 한다.
		PrintWriter out = response.getWriter();
		// 3-3. 데이터 통로(Stream)을 통해서 데이터를 출력!!
		out.println("이것은 소리없는 아우성!!");
		out.println("두번째 데이터");
		out.println("세번째 데이터");
		// 3-4. 보낼 데이터가 다 준비되면 특정 method를 이용해서 진짜 보냄.
		out.flush();
		// 3-5. 처리가 끝났으니 통로를 닫음.
		out.close();
		
		// MVC 패턴으로 코드 수정.
		// 우리 Servlet은 controller의 역할을 담당.
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
