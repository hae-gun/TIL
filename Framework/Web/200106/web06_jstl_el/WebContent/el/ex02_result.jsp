<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %> <!-- 별칭등록. -->
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %> 

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ex02_result.jsp 결과 받아줄 페이지</title>	
	</head>
	
	<body>
		<%-- <%
		
			request.setCharacterEncoding("UTF-8"); /* 한글깨짐 방지 */
			String name = request.getParameter("name");
			String search = request.getParameter("search");
			int age = Integer.parseInt(request.getParameter("age")); /* 받아오는 값은 모두 String 문자열. */
			out.print(age);
		%><br>
		
		<%=name %>님 검색어는<%=search %> 입니다. --%>
		
		<fmt:requestEncoding value="UTF-8"/><!--request.setCharacterEncoding("UTF-8"); 대체 오류가 살짝 있음.-->
		
		<h3>msg : ${ sessionScope.msg }</h3> 
		
		<h3>이름 : ${ param.name } or ${ param['name'] }</h3> <%-- 표현식(<%= %>)을 대체하는 EL --%> 
		
		<h3>검색어 : ${ param.search }</h3> 
		<h3>나이 : ${ param.age }</h3> 
		

	</body>
	
</html>