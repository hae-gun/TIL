<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	if(id.equals(pw)){
		session.setAttribute("memberID", "cat");
		session.setAttribute("phone", "010");
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인 성공</h2>
	<a href="loginCheck.jsp">로그인 상태 확인</a>
</body>
</html>

<% 
	}else{ //로그인 실패시
%>

<script type="text/javascript">
 alert("로그인 실패");
 history.go(-1);
</script>

<%} %>




