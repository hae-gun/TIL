<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 클라이언트 단에서 적용된 코드. -->
	<h2 id="today"></h2>
	<script type="text/javascript">
	
		var today = new Date();
		document.getElementById("today").innerHTML = today;
	</script>
	<!-- jsp 를 이용한 날짜 출력 -->
	<h2><%=new Date()%></h2>
	
	
</body>
</html>