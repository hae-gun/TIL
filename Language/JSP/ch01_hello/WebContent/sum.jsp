<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf8");
	int end = Integer.parseInt(request.getParameter("end"));
	%>
	<%
		long sum = 0;
	for (int i = 1; i <= end; i++) {
		sum += i;
	}
	%>
	<h1>
		1 ~ <%=end%>까지의 합계는? <span><%=sum%></span>
	</h1>
</body>
</html>