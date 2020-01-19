<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ex03_login.jsp </title>
	</head>
	<body>
	
		<table>
			<form action="ex03_loginOK.jsp"  method="post">
				<tr>
					<td>User ID : <input type="text" name="id">  </td>
				</tr>
				<tr>
					<td>User PWD : <input type="password" name="pwd">  </td>
				</tr>
				<tr>
					<td>
						Hobby:
						<input type="checkbox" name="hobby" value="baseball" >Baseball
						<input type="checkbox" name="hobby" value="soccer" >Soccer 
						<input type="checkbox" name="hobby" value="basketball" >Basketball 
					 </td>
					
				</tr>
				<tr>
					<td>
						<input type="submit"  value="Login" > 
					 </td>
				</tr>
			</form>
		</table>
	</body>
</html>