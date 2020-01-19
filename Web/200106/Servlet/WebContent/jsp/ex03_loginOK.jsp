<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ex03_loginOK.jsp</title>
	</head>
	<body>
	
		Model 1방식
		<% 
			
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");	
		String pw = request.getParameter("pwd");	
		out.print(id + ", "+pw);
		
		//여러개의 데이터 받아오기.
		//String[] hobbys = request.getParameterValues("hobby"); 스트링 배열로 바로 받기.(getParameterValues)
		
		
		Map map = request.getParameterMap(); // Map을 이용하여 받기. (getParameterMap())
		String[] hobbys = (String[])map.get("hobby");
		
		
		%><br>
	<%= "당신의 아이디 :" + id %><br>
	<%= "당신의 Password :" + pw %><br>
	
	<%="당신의 취미: " %>
	<%
		if(hobbys != null){
			for(int i=0; i<hobbys.length; i++){
	%>			
	
		<%= hobbys[i]%> &nbsp;&nbsp;&nbsp;
	<%
			}
		}
	%>
	
	</body>
</html>