package com.sds.date;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/serverDate")

public class ServletDate extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//System.out.println("Hello Servlet");
		response.setCharacterEncoding("EUC-KR"); // 한글꺠짐처리.
		Calendar c = Calendar.getInstance(); // 시스템 날짜 가져오기.
		
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		
		PrintWriter pw = response.getWriter();
		pw.write("<html><head><title>서버측 시간을 얻어서 씁니다.</title></head>");
		pw.write("<body><h1>Hello Servlet</h1><hr>");
		pw.write("<h2> 현재 시간은");
		pw.write(Integer.toString(hour) + ":");
		pw.write(Integer.toString(minute) + ":");
		pw.write(Integer.toString(second));
		pw.write(" 입니다.</h2></body></html>");
		pw.close();
		
	}
	
	
}
