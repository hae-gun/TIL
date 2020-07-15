<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<%-- <%=session.getAttribute("member") %>
	= ${sessionScope.member}
	= ${member } --%>
	<h1>${member.userid} 회원님 로그인하셨습니다.</h1>
	<h2><a href="/mvc/session/mypage">내정보 보러 가기</a></h2>
	<h2><a href="/mvc/session/logout">로그아웃 하러 가기</a></h2>
</body>
</html>