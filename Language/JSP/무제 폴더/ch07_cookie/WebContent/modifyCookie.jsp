<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	Cookie[] cookies = request.getCookies();
if(cookies != null && cookies.length > 0){
	for(int i =0; i < cookies.length; i++){
		if(cookies[i].getName().equals("name")){
			Cookie cookie = new Cookie("name", URLEncoder.encode("JSP 프로그래밍", "utf8"));
			response.addCookie(cookie);
		}
	}
}

%>
</head>
<body>
<h1>쿠키 값 변경</h1>
</body>
</html>