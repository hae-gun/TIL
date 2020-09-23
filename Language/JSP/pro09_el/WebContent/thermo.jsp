<%@page import="util.Thermo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%
	Thermo thermo = new Thermo();
	request.setAttribute("t", thermo);

%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>온도 변환</h3>
	<%-- ${t.setCelsius("서울", 27.1) } --%>
	<%-- <p>서울 온도 - 섭씨: ${t.getCelsius("서울") }도 / 화씨: ${t.getFahrenheit("서울") }</p> --%>
	<p>서울 온도 - 섭씨: ${cel}도 / 화씨: ${fah}</p>
	<p>온도계 정보: ${info}</p>
</body>
</html>