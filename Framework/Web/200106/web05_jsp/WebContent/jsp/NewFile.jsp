<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex01_basic.jsp</title>
<script type="text/javascript">
	document.wrtie("2. javascript 이용 출력");
</script>

</head>
<body>
	<h1>안녕하세요.</h1>
	<p> 1 .tag 이용한 웹 브라우저에 출력합니다.
	
	<%
		String str = "3. 안녕!!! JSP를 이용한 웹 브라우저에 출력합니다.";
		out.print(str);
	
	%><br>
	
	<%!
		public int show(){
			
			return 3+5;
		}
	%>
	
	<hr>
	<%="5555표현식으로 출력"+str %>
	<font size="7" color="red"><%= show() %></font>
	
	
</body>
</html>