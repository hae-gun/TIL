<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<% session.setAttribute("msg", "Session Test"); %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ex02_el.jsp EL Test</title>	
	</head>
	
	<body>
		
		<form action="ex02_result.jsp" method="post">
			<table border="1">
			
				<tr>
					<td>검색 : </td>
					<td><input type="text" name="search" placeholder="검색어를 쓰세요"></td>
				</tr>

				<tr>
					<td>이름 : </td>
					<td><input type="text" name="name" placeholder="이름을 쓰세요"></td>
				</tr>
				
				<tr>
					<td>나이 : </td>
					<td><input type="number" name="age" placeholder="나이를 입력하세요"></td>
				</tr>
				<td colspan = "2" align = "right"><input type="submit" value="전송"></td>
				
			</table>
			
		</form>
		
	</body>
	
</html>