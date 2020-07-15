<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EX01</title>
</head>
<body>
	<h1>
		<c:out value="${view_message_to_info_jsp}"></c:out>
	</h1>
	<form>
		<input type="button" value="NAME"
			onclick="location.href='http://localhost:8085/web07_MVC/MessageCtrlEx01?query_ex01=Name'">
		<input type="button" value="ADDRESS"
			onclick="location.href='http://localhost:8085/web07_MVC/MessageCtrlEx01?query_ex01=Address'">
		<input type="button" value="CONTACT"
			onclick="location.href='http://localhost:8085/web07_MVC/MessageCtrlEx01?query_ex01=Contact'">
		<input type="button" value="???"
			onclick="location.href='http://localhost:8085/web07_MVC/MessageCtrlEx01'">
	</form>
</body>
</html>