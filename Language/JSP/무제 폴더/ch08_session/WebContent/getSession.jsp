<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- request에 대해 session 사용 안 하겠다고 선언 -->
<%-- <%@ page session="false" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		/* 기존의 세션이 존재하면 해당 세션 반환, 없으면 생성 */
		HttpSession httpSession = request.getSession();
		/* 기존의 세션이 존재하면 해당 세션 반환, 없으면 생성 안 해 */
		/* HttpSession httpSession2 = request.getSession(false); */
	%>
	<h1>세션 정보</h1>
	<p>세션 ID: <%=httpSession.getId() %></p>
	<%
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(httpSession.getCreationTime()); 
	%>
	<p>세션 생성 시간: <%=sdf.format(date) %></p>
	<%
		date.setTime(httpSession.getLastAccessedTime());
	%>
	<p>최근 접근 시간: <%=sdf.format(date) %></p>
	
	
	<h1>쿠키 목록</h1>

<%
	Cookie[] cookies = request.getCookies();
	if(cookies != null && cookies.length >0){
		for(int i =0; i < cookies.length; i++){
%>
			<%=cookies[i].getName() %>: 
			<%=URLDecoder.decode(cookies[i].getValue(), "utf8") %><br>
<%		
		}
	}
%>
</body>
</html>