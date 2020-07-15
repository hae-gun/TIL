<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
			번호 : ${detail.seq} <br>
			제목 : ${detail.title} <br>
			작성시간 : ${detail.time} <br>
			조회수 : ${detail.viewcount} <br>
			<a href="./boardlist">목록으로</a>
</body>
</html>