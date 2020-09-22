<%@page import="java.math.BigInteger"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
BigInteger[] arr = new BigInteger[100];
arr[0] = new BigInteger("1");
arr[1] = new BigInteger("2");
for(int i = 2; i < arr.length; i++){
	arr[i] =  arr[i-1].add(arr[i-2]);
}

int num = Integer.parseInt(request.getParameter("num"));
if(num >100)  num =100;



%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>피보나치 수열 계산</h2>
<%
for(int i =0; i < num; i++) {
	out.println(arr[i] + "<br>");
}

%>
</body>
</html>