
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Fibonacci")
public class Fibonacci extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	BigInteger[] arr = new BigInteger[100];
	
	@Override
	public void init() throws ServletException {
		arr[0] = new BigInteger("1");
    	arr[1] = new BigInteger("2");
    	for(int i = 2; i < arr.length; i++){
    		arr[i] =  arr[i-1].add(arr[i-2]);
    	}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num = Integer.parseInt(req.getParameter("num"));
		if(num >100)  num =100;
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<html><body><h2>피보나치 수열 계산</h2>");
		for(int i =0; i < num; i++) {
			out.println(arr[i] + "<br>");
		}
		out.println("</body></html>");
		out.close();
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
