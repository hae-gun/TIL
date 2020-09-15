<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>클라이언트 및 서버 정보</h3>

	<ul>
		<li>클라이언트 ip: <%=request.getRemoteAddr()%></li>
		<li>클라이언트 host: <%=request.getRemoteHost()%></li>
		<li>클라이언트 port: <%=request.getRemotePort()%></li>
		<li>클라이언트 uri: <%=request.getRequestURI()%></li>
		<li>클라이언트 url: <%=request.getRequestURL()%></li>
		<li>클라이언트 sessionId: <%=request.getRequestedSessionId()%></li>
		<li>클라이언트 RealPath: <%=request.getRealPath("request.jsp")%></li>
		<li>요청 정보 전송길이: <%=request.getContentLength()%></li>
		<li>요청 정보 인코딩: <%=request.getCharacterEncoding()%></li>
		<li>요청 정보 콘텐츠 타입: <%=request.getContentType()%></li>
		<li>요청 전송 방식: <%=request.getMethod()%></li>
		<li>ContextPath: <%=request.getContextPath()%></li>
		<li>Protocel: <%=request.getProtocol()%></li>
		<li>서버 이름: <%=request.getServerName()%></li>
		<li>서버 포트: <%=request.getServerPort()%></li>
	</ul>
</body>
</html>