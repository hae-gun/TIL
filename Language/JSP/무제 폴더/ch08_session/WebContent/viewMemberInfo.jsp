<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>세션 정보 조회</h1>

<p>MemberID: <%=session.getAttribute("memberID") %></p>
<p>name: <%=session.getAttribute("name") %></p>
<p>age: <%=session.getAttribute("age") %></p>
</body>
</html>