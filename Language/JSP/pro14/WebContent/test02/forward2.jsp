<%@ page language="java" contentType="text/html; charset=UTF-8"
     import="sec01.ex01.*"  pageEncoding="UTF-8"%>
<%
  request.setCharacterEncoding("utf-8");
  MemberBean member = new MemberBean("lee", "1234", "이순신", "lee@test.com");
  request.setAttribute("member", member); // 무조건 Object가 들어감. 꺼낼때 형변환이 필요하다.
%>    

<html>
<head>
<meta  charset=”UTF-8">
<title>forward2</title>
</head>
<body>
   <jsp:forward page="member2.jsp" />
</html>
