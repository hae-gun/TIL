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
	try{
	int number = Integer.parseInt(request.getParameter("num"));
		log(">>>>>>>>>>>>>>> num:"+number);
		if(number > 9||number<2){%>
			<script>
			alert("2~9숫자를 입력하세요");
			history.go(-1);
			</script>
		<%}
		
			out.println("<h2> 구구단 "+number+"단</h2>");
		for(int i=1;i<10;i++){
			out.println(number+" * "+i+" = "+(number*i)+"<br>");
		}
		
		
		
	}catch(Exception e){%>
		<script>
			alert("숫자를 입력하세요");
			history.go(-1);
		</script>
	<%}
	%>



</body>
</html>