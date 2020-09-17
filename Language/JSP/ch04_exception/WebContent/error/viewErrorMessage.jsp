<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공사중</title>
</head>
<body>
	<h2>요청 처리과정에서 문제가 발생하였습니다.</h2>
	<p>빠른 시간 내에 문제를 해결하도록 하겠습니다.</p>
	<p>
		에러 타입:
		<%=exception.getClass().getName()%>
		<br> 에러 메시지: <b><%=exception.getMessage()%></b>
	</p>
</body>
</html>