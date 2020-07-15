<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="javax.sql.DataSource, javax.naming.*, java.sql.*"%>

<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.*"%>
<%@page import="java.sql.*"%><!-- 유일하게 한줄에 다 써도됨. -->

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>dbcpConnection.jsp</title>	
	</head>
	<body>
	<% 
		try{
			Context ctx = new InitialContext();
			Context envCtx = (Context) ctx.lookup("java:comp/env");
			DataSource ds = (DataSource) envCtx.lookup("jdbc:dbcpTestDB");
			
			Connection conn = ds.getConnection();
			
			out.println("DBCP Connection success......<br><br>");
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	%>
	</body>
</html>