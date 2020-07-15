<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <% ArrayList<BoardVO> list = (ArrayList<BoardVO>)request.getAttribute("boardlist");
		for(BoardVO vo:list){
			out.println("<h3> 번호:"+vo.getSeq());
			out.println(" 제목:"+vo.getTitle());
			out.println(" 내용:"+vo.getContents());
			out.println(" 작성자:"+vo.getWriter());
			out.println(" 작성시간:"+vo.getTime());
			out.println(" 조회수:"+vo.getViewcount()+"</h3>");}
			%> --%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<!-- ArrayList
	<BoardVO> list = (ArrayList<BoardVO>)request.getAttribute("boardlist"); -->
	<c:forEach items="${list}" var="vo">
		<h3>
			번호:  <a href="boarddetail?seq=${vo.seq}">${vo.seq}</a> 
			제목: ${vo.title} 
			내용: ${vo.contents} 
			작성자: ${vo.writer} 
			작성시간: ${vo.time}
			조회수: ${vo.viewcount}
		</h3>
	</c:forEach>
	
	<h3><a href="./boardinsert">글 등록하기</a><br><a href="./boarddelete">글 삭제하기</a></h3>
	
</body>
</html>