<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/gg.css" />
</head>
<body>
	<h2>점심식사</h2>
	<%@include file="today.jsp" %>
	
	<p><%=request.getParameter("name") %>씨, 환영합니다.</p>
	<p>오늘 선택하신 메뉴는 <mark><%=request.getParameter("menu") %></mark> 입니다.</p>
</body>
</html>