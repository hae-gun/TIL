
<%
		String id = request.getParameter("id");
		if(id != null && id.equals("ace")){
			response.sendRedirect("today.jsp");
		}else{%><%@ page language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>잘못된 ID 입니다.</h2>
</body>
</html>
<%}
	%>
