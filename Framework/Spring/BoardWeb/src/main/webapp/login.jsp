<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html14/loose.dtd">
<html>
<head>
<meta charset="EUC-KR">
<title>Login</title>
</head>
<body>
	<center>
		<h1>로그인</h1>
		<hr>
		<form action="login_proc.jsp" method="post">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange">아이디</td>
					<td><input type="text" name="id"/></td>
				</tr>
				<tr>
					<td bgcolor="orange">비밀번호</td>
					<td><input type="password" name="password"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="로그인"/>
				</tr>
			</table>
		</form>

		<hr>
	</center>
</body>
</html>