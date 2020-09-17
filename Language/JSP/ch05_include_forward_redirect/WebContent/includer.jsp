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
<h2>include directive</h2>
	<%
		int num = 10;
	%>
	<!-- directive include 사용시 코드채로 가져와서 여기서 컴파일 수행한다. -->
	<%@ include file="includee.jspf" %>
	
	<!-- jsp:include 로 가져오면 해당 jsp를 먼저 컴파일 한후 결과를 가져온다. -->
	<h2>jsp action include</h2>
	<jsp:include page="includee.jspf" flush="false"></jsp:include>
	
	<p>공통변수 data folder = <%=dataFolder %></p>
</body>
</html>