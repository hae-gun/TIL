<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/gg.css">
</head>
<body>
	<p>main.jsp에서 생성한 내용</p>
	<!-- include directive -->
	<%@include file="sub.jsp" %>
	
	<jsp:include page="sub.jsp" flush="false"></jsp:include>
	<p>include 이후의 내용</p>
</body>
</html>