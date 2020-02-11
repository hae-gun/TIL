<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>${member.userid} 로그아웃완료.</h1>
	<%session.removeAttribute("member"); %> <!-- jsp에는 session 내장 객체가 있어서 사용이 가능하다. -->
	${member} 값 -->출력
</body>
</html>