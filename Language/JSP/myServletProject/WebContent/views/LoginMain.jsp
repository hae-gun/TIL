<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("UTF-8");
%>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
function fn_process(){
	
	var queryString = $("form[name=loginForm]").serialize();
	
    $.ajax({
      type:"post",
      dataType:"text",
      async:false,  
      url:"http://localhost:8080/myServletProject/login/userLogin",
      data: queryString,
      success:function (data,textStatus){
    	 submit();
         console.log(textStatus);
         
      },
      error:function(data,textStatus){
         alert("에러가 발생했습니다.");
      },
      complete:function(data,textStatus){
         //alert("작업을완료 했습니다");
      }
   });	
}

</script>
</head>
<body>
	hello Login
	<br />
	<br />
	<form name="loginForm" action="${contextPath}/login/userLogin" method="post">
		id: <input type="text" name="id" /><br /> <br /> pw: <input type="password" name="pw"/>
		<br /> <br /> <input type="submit" value="login" /> 
		<!-- <a href="#" onclick="fn_process()">login</a> -->
	</form>


	<a href="${contextPath}/login/register">register</a>
</body>
</html>