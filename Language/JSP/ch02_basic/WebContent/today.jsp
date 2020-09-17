<%@page import="java.util.GregorianCalendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		GregorianCalendar gc = new GregorianCalendar();
		String date = String.format("%TF %TT",gc,gc);
	%>
	
	<div>현재 일시는<%=date %></div>
	
	<h3><a href="https://search.daum.net/search
	?w=tot&DA=YZR&t__nil_searchbox=btn
	&sug=&sugo=&q=%EA%B0%80%EC%9D%84">다음에서 가을 검색</a></h3>
	
</body>
</html>