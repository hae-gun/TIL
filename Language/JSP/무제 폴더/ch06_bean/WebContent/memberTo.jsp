<%@page import="dto.MemberInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<% MemberInfo mi = (MemberInfo) request.getAttribute("mem");%>

<h2>회원 ID : <%=mi.getId()%></h2>
<h2>회원 이름 : <%=mi.getName()%></h2>