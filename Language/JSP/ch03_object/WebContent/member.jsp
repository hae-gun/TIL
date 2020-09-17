<%@page import="java.util.Arrays"%>
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
	<%
		request.setCharacterEncoding("utf8");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String[] hobbies = request.getParameterValues("hobby");
		String[] specs = request.getParameterValues("spec");
	
	%>
	
	<h2>
		<%=name %> <br />
		<%=age %> <br />
		취미: <%=hobbies!=null? Arrays.toString(hobbies):"---" %> <br />
		기술: <%=specs!=null? Arrays.toString(specs):"---" %> <br />
	
	</h2>
	
	<div>
		<%=application.getAttribute("1") %>
	</div>
	
</body>
</html>