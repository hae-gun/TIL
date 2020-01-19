<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		<%
			//java code - jsp
			String str = "JSTL 테스트 입니다.";
			out.print(str);
		%><hr>
		
		JSTL core 라이브러리 사용 예제
		<br>
		<c:set var = "msg" value = "JSTL 테스트 입니다."/>
		<h1><c:out value="${msg}"/></h1>
		
		<c:set  value="최혜근" var = "name"/> 
		<h2>이름 : <c:out value="${name}"/></h2>
		
		<c:set var = "num">1000</c:set>
		<c:out value="${num}"/><font color="red">원</font>
		<hr>
		
		<c:catch var="error">
			<%=10/0 %>
		</c:catch>
		
		<h3>&lt;c:catch&gt; 로 잡아낸 오류: <c:out value="${error}"/></h3>
				
	</body>
</html>