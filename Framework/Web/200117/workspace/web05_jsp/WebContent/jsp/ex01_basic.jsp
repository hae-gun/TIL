<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ %>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>ex01_basic.jsp</title>
<script type="text/javascript">
		document.write("2. javascript 이용해서 출력했어요~~~");
</script>
</head>
<body>
	<h1> 안녕하세요.</h1>
	<p>1.  tag 이용한 웹 브라우저에 출력합니다.
	
	<%
		 	String str = "3. 안녕!!! JSP를 이용한 웹 브라우저에 출력합니다. 표현식으로 출력";
			//out.print(str);
	%><br>
	<hr>
	<%!
			public int show(){
				return 3+5;
			}
	%>
	
	<%= " 5555표현식으로 출력" + str %><br>
	<font size="7" color="red" > <%= show() %></font>
</body>
</html>













