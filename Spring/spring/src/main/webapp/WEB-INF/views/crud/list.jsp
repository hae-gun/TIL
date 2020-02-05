<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	list.jsp파일
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:forEach items="${members}" var="m">	
		<h3><a href="http://localhost:8080/mvc/crud/get?id=${m.key}">아이디</a>   이름 : ${m.value}</h3>
	</c:forEach>
	
</body>
</html>