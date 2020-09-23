<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%
  // 새션에 붙인값 -> 포워드 하기 전 값이 
  session.setAttribute("address","수원시 팔달구");
%> 

<html>
<head>
<meta charset=”UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
<table border="1" align="center"   >
   <tr align="center"  bgcolor="#99ccff">
      <td width="7%"><b>아이디</b></td>
      <td width="7%"><b>비밀번호</b></td>
      <td width="5%" ><b>이름</b></td>
      <td width="5%"><b>이메일</b></td>
      <td width="5%" ><b>주소</b></td>
   <tr>
   <tr align="center">
       <!-- el태그 찾는 순서 좁은 순서부터 pageContext -> request -> session -> application 순서로 찾는다. -->
       <td>${id } </td>
       <td>${pwd } </td>
       <td>${name } </td>
       <td>${email }</td>
       <td>${address }</td>
    </tr>
</table>
</html>