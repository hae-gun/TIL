<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
		String type = request.getParameter("type");
		log("type>>> " + type);
		if(type == null){
			return;
		}
	%>
	
	<table>
		<tr>
			<td>타입</td>
			<td><%=type %></td>
		</tr>
		<tr>
			<td>특징</td>
			<td>
				<%if(type.equals("A")){ %>
					<h3>강한 내구성</h3>			
				<%}else if(type.equals("B")){ %>
					<h3>뛰어난 대처 능력</h3>
				<%}else if(type.equals("C")){  %>
					<h3>초강력 살상 능력</h3>
				<%} %>
			</td>
		</tr>
	</table>
