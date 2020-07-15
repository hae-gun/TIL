<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

	<form action="/mvc/session/loginprocess" method="POST">
		<table >	
		<tr><td>아이디</td><td> <input type="text" id="a" name="userid"></td></tr> <!-- 요청 파라미터 이름은 input tag의 name속성. id는 css적용할떄. 보통 같은이름으로 지정.-->
		<tr><td>암호 </td><td><input type="password" id="b" name="password"></td></tr> <!-- 요청 파라미터 이름은 input tag의 name속성. id는 css적용할떄. 보통 같은이름으로 지정.-->
		<tr><td colspan="2"><input type="submit" value="로그인"></td></tr> <!-- 요청 파라미터 이름은 input tag의 name속성. id는 css적용할떄. 보통 같은이름으로 지정.-->
		
		
		</table>
	</form>
	
</body>
</html>