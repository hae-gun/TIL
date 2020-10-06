<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="list" value="${list}" />
<%
	request.setCharacterEncoding("UTF-8");
%>

<style>
	.center{
		margin-top: 14%;
		text-align: center;
	}

</style>
</head>
<body>
	<div class="center">
	userList
	<br>
	<table align="center" border="1" width="80%">
		<tr>
			<td>사번</td>
			<td>이름</td>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이메일</td>
			<td>연봉(천만)</td>
			<td>판매금액(천만)</td>
			<td>입사일</td>
		</tr>

		<c:forEach var="user" items="${list}" varStatus="articleNum">
			<tr>
				<td>${user.empNo}</td>
				<td>${user.ename}</td>
				<td>${user.empId}</td>
				<td>${user.empPassword}</td>
				<td>${user.email}</td>
				<td>${user.salary}</td>
				<td>${user.sales}</td>
				<td>${user.joinDate}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="${contextPath}/login/userLogin">메뉴</a><br/>
	</div>
</body>
</html>