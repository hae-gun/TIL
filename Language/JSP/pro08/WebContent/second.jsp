<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%String name=request.getParameter("name");
   %> --%>
   <h1>
   이름: <%-- <%=name%> --%> ${param.name }</h1>
   <br>
dispatch로 보냈어요~~
</body>
</html>