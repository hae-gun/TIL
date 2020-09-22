<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.net.URLEncoder"%>
<%
	Cookie cookie2 = new Cookie("only", "onlycookie");
	response.addCookie(cookie2);

	Cookie cookie1 = new Cookie("id", "ace");
	cookie1.setDomain("somehost.com");
	response.addCookie(cookie1);

	Cookie cookie3 = new Cookie("in", "incookie");
	cookie3.setDomain("mail.somehost.com");
	response.addCookie(cookie3);
	
	Cookie cookie4 = new Cookie("my", "girl");
	cookie4.setDomain("java.wings.com");
	response.addCookie(cookie4);
%>
<html>
<head>
<title>쿠키생성</title>
</head>
<body>

	다음과 같이 쿠키를 생성했습니다.
	<br>
	<%=cookie1.getName()%>=<%=cookie1.getValue()%>
	[<%=cookie1.getDomain()%>]
	<br>
	<%=cookie2.getName()%>=<%=cookie2.getValue()%>
	[<%=cookie2.getDomain()%>]
	<br>
	<%=cookie3.getName()%>=<%=cookie3.getValue()%>
	[<%=cookie3.getDomain()%>]

</body>
</html>
