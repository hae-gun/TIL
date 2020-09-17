<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/gg.css"/>
</head>
<body>

<%
	Object nick = "바보";
	// application 객체의 범위는 해당 프로젝트 범위이다.
	application.setAttribute("1", nick);
%>

<fieldset>
	<legend>회원가입</legend>
	<form action="member.jsp" method="get">
		<table>
			<tr>
				<td>이름: </td>
				<td><input type="text" name="name"/></td>
			</tr>
			
			<tr>
				<td>나이:</td>
				<td><input type="text" name="age"/></td>
			</tr>
			
			<tr>
				<td>취미: </td>
				<td>
					<input type="checkbox" name="hobby" value="낚시"/>낚시
					<input type="checkbox" name="hobby" value="골프"/>골프
					<input type="checkbox" name="hobby" value="사냥"/>사냥
				</td>
			</tr>
			
			<tr>
				<td>특기: </td>
				<td><select name="spec" multiple="multiple" size="4">
				<option  selected="selected">Coding</option>
				<option>Programming</option>
				<option>App Making</option>
				<option>DB Managing</option>
				
				</select></td>
			</tr>
			
		</table>
		<input type="submit" value="전송" class="btn">
	</form>
</fieldset>
</body>
</html>