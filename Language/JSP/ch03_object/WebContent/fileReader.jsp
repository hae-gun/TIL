<%@page import="java.io.IOException"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
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
		String path = "/text/poem.txt";
	URL url = application.getResource(path);
	log(">>>>>>>>>>>>>>>>>>>>>>>>>");
	log(">>>>>url: " + url.toString());
	log(">>>>>>>>>>>>>>>>>>>>>>>>>");
	%>
	<h2>자원의 실제 경로:</h2>
	<%=application.getRealPath(path)%>
	<hr />
	<p>
		<%
			char[] buff = new char[128];
		int len = -1;
		try {
			InputStreamReader is = new InputStreamReader(url.openStream(), "utf8");
			while ((len = is.read(buff)) != -1) {
				out.println(new String(buff, 0, len));
			}
		} catch (IOException e) {
			out.println(e.getMessage());
		}
		%>
	</p>
</body>
</html>