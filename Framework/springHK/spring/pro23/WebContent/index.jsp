<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>myBatis 사용법</h1>
	<ol>
		<li>myBatis 라이브러리 다운로드 받아서 해당 위치에 저장</li>
		<li>myBatis config 파일(xml) 작성 - dto alias, connection 설정, mapper 등록</li>
		<li>myBatis mapper 파일 작성 - 사용할 sql 하나씩 등록, 반환 타입(DTO,HashMap) 설정</li>
		<li>myBatis mapper를 활용하는 DAO 작성</li>
	</ol>
	<button onclick="location.href='${pageContext.request.contextPath}/mem4.do'">마이바티스 사용</button>
</body>
</html>