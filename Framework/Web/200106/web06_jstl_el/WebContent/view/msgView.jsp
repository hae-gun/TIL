<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>msgView.jsp</title>	
	</head>
	<body>
		전달된 결과:
		<h2><c:out value="${result}"></c:out></h2>
	
	</body>
</html>