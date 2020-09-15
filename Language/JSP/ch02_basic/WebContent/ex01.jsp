<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 상대경로로 지정 -->
<!-- <link rel = "stylesheet"type="text/css" href="css/gg.css"> -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/gg.css" />
</head>
<body>
	<form action="ex02.jsp">
		이름: <input type="text" name="name" />
		메뉴: <input type="radio" name="menu" value="햄버거" />햄버거
		<input type="radio" name="menu" value="갈비탕" />갈비탕
		<input type="radio" name="menu" value="불고기" />불고기
		
		<input type="submit" value="확인" />
	</form>
</body>
</html>