<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/gg.css">
<%
	String kind = request.getParameter("kind");
	String price = request.getParameter("price");
	String type = request.getParameter("type");
%>
</head>
<body>
<table>
		<tr>
			<td>제품종류</td>
			<td><%=kind %></td>
		</tr>
		<tr>
			<td>가격</td>
			<td><%=price %></td>
		</tr>
		<tr>
			<td>타입</td>
			<td><%=type %></td>
		</tr>
	</table>
	
	<jsp:include page="infoSub.jsp" flush="false">
		<jsp:param value="<%=type%>" name="type"/>
	</jsp:include>
</body>
</html>