<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	
	Cookie cookie = new Cookie("auth", "");
	/* cookie 삭제 효과 - expire : session  */
	 cookie.setMaxAge(0);
	response.addCookie(cookie);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>logout</title>
</head>
<body>
	<h3>로그아웃 되었습니다.</h3>
	<a href="loginForm.jsp">로그인</a>
</body>
</html>