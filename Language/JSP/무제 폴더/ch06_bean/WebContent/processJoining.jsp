<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf8");
	/* String id = request.getParameter("id"); */
%>

<jsp:useBean id="memberInfo" class="dto.MemberInfo" scope="page"/>

<!-- type은  request에 빈 객체가 달려 있을 때 사용 -->
<%-- <jsp:useBean id="memberInfo" type="dto.MemberInfo" scope="request"/> --%>

<%-- <jsp:setProperty property="id" name="memberInfo" param="id"/>
<jsp:setProperty property="name" name="memberInfo" param="name"/>
<jsp:setProperty property="email" name="memberInfo" param="email"/> --%>

<jsp:setProperty property="*" name="memberInfo"/>
<%-- <jsp:setProperty property="password" name="memberInfo" value="<%=memberInfo.getId() %>"/> --%>
<% log(memberInfo.getId()); %>
<!-- db에 insert -->  
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- db에서 회원정보 가져와서 빈 생성하고 빈에서 값 뽑아서 출력 -->
	<table width="400" border="1" cellpadding="0" cellspacing="0">
<tr>
	<td>아이디</td>
	<td><jsp:getProperty name="memberInfo" property="id" /></td>
	<td>암호</td>
	<td><jsp:getProperty name="memberInfo" property="password" /></td>
</tr>
<tr>
<tr>
    <td>이름</td>
    <td><jsp:getProperty name="memberInfo" property="name" /></td>
    <td>이메일</td>
    <td><jsp:getProperty name="memberInfo" property="email" /></td>
</tr>
</table>
</body>
</html>