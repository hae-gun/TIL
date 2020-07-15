<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전송 결과 확인 페이지</title>
</head>
<body>
	<%
	String name = request.getParameter("name");
	String pass = request.getParameter("pwd");
	
	out.print(name + " 님 반가워요 비번은 :" + pass);
	
	%>
	
	
	<!-- 셋중 하나 Java code 가능 -->
</body>
</html>