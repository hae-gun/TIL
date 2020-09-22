<%@page import="dto.MemberInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

MemberInfo mi = new MemberInfo();
mi.setId("ace");
mi.setName("blue");

request.setAttribute("mem", mi);
%>

<jsp:forward page="memberTo.jsp"/>