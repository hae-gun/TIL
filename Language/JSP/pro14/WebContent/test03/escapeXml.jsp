<%@ page language="java" contentType="text/html; charset=UTF-8"
     import="java.io.*"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html >
<html>
<head>
<meta charset=”UTF-8">
<title>escapeXml 실습하기</title>
</head>
<body>
<h2>escapeXml 변환하기</h2>
<h2>
<pre>
  escapeXml : true => 특수기호아니고 글자 그대로 출력
  			  false => escape 문자로 출력시킨다.
  <c:out  value="&lt;" escapeXml="true" />
  <c:out  value="&lt;" escapeXml="false" />
  ${'&lt' }
  &lt
 
  <c:out  value="&gt;" escapeXml="true" />
  <c:out  value="&gt;" escapeXml="false" />
 
  <c:out  value="&amp;" escapeXml="true" />
  <c:out  value="&amp;" escapeXml="false" />

  <c:out  value="&#039;" escapeXml="true" />
  <c:out  value="&#039;" escapeXml="false" />
 
  <c:out  value="&#034;" escapeXml="true" />
  <c:out  value="&#034;" escapeXml="false" />
</pre>
</h2>
</body>
</html>
