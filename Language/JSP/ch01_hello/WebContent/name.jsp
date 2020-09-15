<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
// 내장객체 request가 내장되어 있다.
// tomcat 이 jsp 파일에 자바 코드를 전부 제거한후\
// 자바 코드의 결과를 html에 받아서 클라이언트에게 보여준다.
// 즉 JSP 코드는 서버단에서 컴파일 한다.
	request.setCharacterEncoding("utf8");
	String name = request.getParameter("name");
%>
</head>
<body>

	
	<h1>당신의 이름은 <%=name %> 이군.</h1>
	
	
</body>
</html>