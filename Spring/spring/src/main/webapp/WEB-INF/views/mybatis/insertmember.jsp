<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<form action="/mvc/session/insertmember" method="POST">
		<table>
			<tr><td>ID</td><td><input type="text" name="userid"></td></tr> 
			<tr><td>PASSWORD</td><td><input type="password" name="password"></td></tr> 
			<tr><td>이름</td><td><input type="text" name="name"></td></tr> 
			<tr><td>핸드폰번호</td><td><input type="text" name="phone"></td></tr>
			<tr><td colspan="2"><input type="submit" value="회원가입"></td></tr>
		</table>
	</form>
</body>
</html>