<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	이름: <c:out value="${name}"></c:out> <br>
	주소: <c:out value="${addr}"></c:out> <br>
	연락처: <c:out value="${phone}"></c:out>
</body>
</html>