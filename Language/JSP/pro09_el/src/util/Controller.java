package util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/thermo")
public class Controller extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset-utf-8");
		Thermo t = new Thermo();
		t.setCelsius("서울", 27.1);
		
		
		double cel = t.getCelsius("서울");
		double fah = t.getFahrenheit("서울");
		String info = t.getInfo();
		
		request.setAttribute("cel", cel);
		request.setAttribute("fah", fah);
		request.setAttribute("info", info);
		RequestDispatcher dispatcher = request.getRequestDispatcher("thermo.jsp");
		dispatcher.forward(request, response);
		
	}
	
}
