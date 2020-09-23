<%@page import="java.util.Arrays"%>
<%@page import="util.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%! 
	int gt(int a, int b){
		if (a > b) 
			return a;
		else
			return b;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>EL 함수</h2>
<p><%=gt(298, 312) %></p>

<!-- 람다식 -->
${greaterThan = (a, b) -> a > b? a : b; '' }
${greaterThan(33, 55) }

<hr>
${fac = n -> n == 1 ? 1 : n + n*fac(n-1); '' }
${fac(5) }

<hr />
${ vals = [20, 17, 30, 2, 9, 23] ; sortedVals = vals.stream().sorted().toList() }
<hr />
\${vals } : ${vals }
<hr />
<!-- stream() : sum(), filter(), map(), 
sorted(), limit(), count(), toList() etc -->
\${vals.stream().sum()}: ${vals.stream().sum()}<br>
\${vals.stream().filter(x -> x>=20).sum() }: 
${vals.stream().filter(x -> x>=20).sum() }<br>
\${vals.stream().filter(x -> x<10).map(x -> x*x).sum() }:
${vals.stream().filter(x -> x<10).map(x -> x*x).sum() } <br>
\${vals.stream().sorted().limit(3).toList() } : 
${vals.stream().sorted().limit(3).toList() }<br>
\${vals.stream().count() } :
${vals.stream().count() }

<hr>
<!-- anyMatch(), allMatch(), noneMatch() -->
${matchOpt = vals.stream().anyMatch(v -> v > 25);'' }
${matchOpt.get()}
<hr>
${matchOpt = [].stream().allMatch(v -> v > 25);'' }
<%-- ${matchOpt.get()} 빈 Optional 객체에서 get() 사용하면 에러 발생--%>
${matchOpt.orElse(false)} 

<hr>

<%
    List<Member> memberList = Arrays.asList(
        new Member("홍길동", 20), new Member("이순신", 54),
        new Member("유관순", 19), new Member("왕건", 42) );
    request.setAttribute("members", memberList);
%>


${sortedMem = members.stream().sorted((a, b)-> a.age.compareTo(b.age)).toList();'' }
${sortedMem }
<hr />

<!-- map: 원소를 변환한 새로운 스트림 생성. 컬렉션에 포함된 원소에서 
특정 값을 추출하는 용도에 적합 -->
${members.stream().map(x -> x.age).toList() }
<!-- 20세 이상의 회원들 평균 나이: map으로 각 객체의 나이를 추출하고 
filter로 20세 이상만 추려낸 후에 평균을 내고 Optional 객체를 get()으로 출력함 -->
<hr />
${members.stream().map(x -> x.age ).filter(x -> x >= 20).average().get()}






</body>
</html>