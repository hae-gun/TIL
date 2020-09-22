<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%!
	//매개변수로 리퀘스트에 포함된 쿠키들을 받아서 이름이 auth인 쿠키가 있는지 확인하고 있으면 해당 인덱스 반환
	public int existCookie(Cookie[] cookies){
	int result = -1;
	 
	if (cookies != null && cookies.length > 0) { 
	for (int i = 0; i < cookies.length; i++) { 
		if (cookies[i].getName().equals("auth")) {
			result = i;	
		}
	}
	}
	return result;
	}
%>

<%
	Cookie[] cookies = request.getCookies();
	int cookNum = existCookie(cookies);
	if(cookNum > -1){
%>
	<h3>
		id: "<%=cookies[cookNum].getValue()%>로 로그인하신 상태입니다.
	</h3>
	<a href="logout.jsp">로그아웃</a>
<%
	
	}else { 
%>
<h3>로그인 하지 않으셨습니다</h3>
<%
	}
%>
