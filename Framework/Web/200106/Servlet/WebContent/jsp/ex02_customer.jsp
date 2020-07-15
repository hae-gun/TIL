<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="edu.db.custom.Customer"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ex02_customers.jsp 데이터베이스에 있는 래코드 출력</title>
	</head>
	<body>
		<%
		Customer cus = new Customer();
		cus.setName("최혜근");
		cus.setPhone("010010010");
		/* out.print(cus); */
		%><br>
		
		<%= cus %>
	
	
	</body>
</html>