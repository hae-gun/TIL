<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.zip.DataFormatException"%>
<%@page import="java.util.Date"%>
<%@page import="dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/gg.css" />
</head>
<body>
	<h2>유저</h2>
	<%
	
		User p1 = new User("luv1","예진",41,new Date());
		User p2 = new User("luv2","효진",43,new Date());
		User p3 = new User("luv3","세진",47,new Date());
		User p4 = new User("luv4","진",39,new Date());
		ArrayList<User> users = new ArrayList<>();
		users.add(p1);
		users.add(p2);
		users.add(p3);
		users.add(p4);
		
	%>
	<table>
	<% SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일"); %>
		
	
	<%
		for(User u:users){%>
			<tr>
			<td><%=u.getId()%></td>
			<td><%=u.getName()%></td>
			<td><%=u.getAge()%></td>
			<td><%=sdf.format(u.getHiredate())%></td>
		</tr>
			
		<%}
		
	%>
		
	</table>
</body>
</html>