<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	request.setAttribute("name", "tom");
%>
</head>
<body>
<h1>Expression Language</h1>
	<p><%=request.getContextPath() %></p>
	<p>${pageContext.request.contextPath }</p>
	
	<p><%=request.getAttribute("name") %></p>
	<p>${name }</p>
	<p>${requestScope.name }</p>
	
	<p>파라미터</p>
	<p><%=request.getParameter("code") %></p>
	<p>${param.code }</p>
	
	<p>EL은 계산식이나 코드를  포함할 수 있다</p>
	<div>${33*77 }</div>
	<div>${"10" + 55 }</div>
	<div>${"김"+= "지언" +=" 바보" }</div>
	
	
</body>
</html>