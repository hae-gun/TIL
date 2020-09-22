<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	String memberID = (String)session.getAttribute("memberID");
	boolean login = memberID == null? false : true;
	if(login){
%>
	<h3>
		id: "<%=memberID%>로 로그인하신 상태입니다.
	</h3>
	<a href="logout.jsp">로그아웃</a>
<%
	
	}else { 
%>
<h3>로그인 하지 않으셨습니다</h3>
<%
	}
%>
