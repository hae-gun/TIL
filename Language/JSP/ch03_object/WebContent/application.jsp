<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Enumeration<String> attrEnum = application.getAttributeNames();
	while(attrEnum.hasMoreElements() ) {
		String name = attrEnum.nextElement();
		Object value = application.getAttribute(name);
%>
application 속성 : <b><%= name %></b> = <%= value %> <br>
<%
	}
%>
<hr size="10">
<%
	String info = application.getServerInfo();
	int mav = application.getMajorVersion();
	int miv = application.getMinorVersion();
	String conPath = application.getContextPath();
	String realPath = application.getRealPath("member.jsp");
	application.log("오늘 수업이 슬슬 끝나가나 ㅋㅋ 노세 노세 젊어서 놀아");
%>
서버 정보: <%=info %><br>
서버 버전: <%=mav %>.<%=miv %><br>
conPath: <%=conPath %><br>
realPath: <%=realPath %><br>


<%
	log("로그 메시지 기록");
%>
</body>
</html>