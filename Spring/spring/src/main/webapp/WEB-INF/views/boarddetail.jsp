<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boarddetail</title>
</head>
<body>
	<h3>
		번호: ${vo.seq}
		제목: ${vo.title}
		내용: ${vo.contents} 
		작성자: ${vo.writer} 
		작성시간: ${vo.time} 
		조회수: ${vo.viewcount}
	</h3>
</body>
</html>