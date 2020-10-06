<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("UTF-8");
%>

</head>
<body>
	
	main page
	
	만들것 
	
	메뉴선택
	
	<div><a href="${contextPath}/login//allUser">사원목록</a></div>
	<div><a href="#">재고상태</a></div>
		
	
</body>
</html>