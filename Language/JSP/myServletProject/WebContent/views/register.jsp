<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
	request.setCharacterEncoding("utf-8");
%>
<title>Insert title here</title>
<script>

	
	
</script>
</head>
<body>
	인사 등록
	<form name="memberForm" method="post" action="${contextPath}/login/registerUser"  enctype="multipart/form-data">
	<table>
		<tr>
			<td>인사번호:</td>
			<td><input type="text" name="empno"></td>
		</tr>
		<tr>
			<td>이름:</td>
			<td><input type="text" name="ename"></td>
		</tr>
		<tr>
			<td>ID:</td>
			<td><input type="text" name="empid"></td>
		</tr>
		<tr>
			<td>PW:</td>
			<td><input type="password" name="emppassword"></td>
		</tr>
		<tr>
			<td>email:</td>
			<td><input type="email" name="email"></td>
		</tr>
		<tr>
			<td>연봉:</td>
			<td><input type="number" name="salary"></td>
		</tr>
		<tr>
			<td><input type="submit" value="등록"/></td>
			<td><a href="">뒤로가기</a></td>
		</tr>
	</table>
	<a href=""></a>
	</form>
</body>	
</html>