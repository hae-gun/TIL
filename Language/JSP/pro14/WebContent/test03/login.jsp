<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     isELIgnored="false"  %>
     <!-- isElignored : true이면 el태그를 무시함 false가 default 값이다. 필요할 때 쓴다. -->
     
 <!-- taglib : 외부 라이브러리를 사용할 때 사용. jstl 사용. -->    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %><!-- core와 fmt를 자주 사용한다. -->
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>로그인 창</title>
</head>
<body>
   <form action="result.jsp">
아이디 : <input type="text" size=20 /><br>
비밀번호: <input  type="password"  size=20 /><br>
<input  type="submit" value="로그인" /> <input type="reset" value="다시입력"  />
   </form> 
   <br><br>
   <%-- 
<a href="${pageContext.request.contextPath}/memberForm.jsp">회원등록하기</a>
 --%>
      <a href="${contextPath}/test03/memberForm.jsp">회원등록하기</a>
   
</body>
</html>
