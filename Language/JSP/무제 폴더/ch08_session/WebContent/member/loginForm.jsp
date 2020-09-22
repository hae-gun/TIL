<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>김지언과 똑똑박사의 세션 연주하기</h1>
	<form action="<%=request.getContextPath()%>/member/login.jsp">
		ID: <input type="text" name="id" /><br>
		PW: <input type="text" name="pw" />
		<hr />
		<input type="submit" value="로그인" />
	
	</form>
</body>
</html>