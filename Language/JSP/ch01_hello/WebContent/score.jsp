<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<h1>JSP</h1>
	<%
		double[] score = {77.98, 82.34, 100, 69.47};
	
	double sum =0;
	double avg = 0;
	out.println("<h2>"+Arrays.toString(score)+"의총점과 평균");
	
	for(int i=0; i<score.length; i++){
		
		sum += score[i];
	}
	
	avg = sum/score.length;
	
	out.println("<table>");
	out.println("<tr>");
	out.println("<td> 총점 </td>");
	out.println("<td> 평균 </td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td>"+sum+"</td>");
	out.println("<td>"+avg+"</td>");
	out.println("</tr>");
	out.println("</table>");
	
	%>
	
	
	
	
	
