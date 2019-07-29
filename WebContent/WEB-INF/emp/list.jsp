<%@page import="java.net.URLDecoder"%>
<%@page import="emp.dto.EmpDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR"> 
	<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<EmpDTO> userlist = (ArrayList<EmpDTO>)request.getAttribute("userlist");
		int size = userlist.size();
		EmpDTO user = null;
		
	%>
		<jsp:include page="search.jsp"/>
		<h1>회원목록보기(jsp로 분리)</h1>
		<hr/>
	
		<table border="1">
			<thead>
				<tr bgColor="#ffff99">
					<th>아이디</th>
					<th>비밀번호</th>
					<th>이름</th>
					<th>주소</th>
					<th>입사일</th>
					<th>등급</th>
					<th>포인트</th>
					<th>부서번호</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<%for(int i=0; i<size; i++){ 
				user = userlist.get(i);%>
				<tr>
					<td><a href="/serverweb/emp/read.do?id=<%=user.getId()%>&action=READ"><%=user.getId() %></a></td>
					<td><%=user.getPass() %></td>
					<td><%=user.getName() %></td>
					<td><%=user.getAddr() %></td>
					<td><%=user.getHiredate() %></td>
					<td><%=user.getGrade() %></td>
					<td><%=user.getPoint() %></td>
					<td><%=user.getDeptNo() %></td>
					<td><a href="/serverweb/emp/delete.do?info=test&id=<%=user.getId()%>">삭제</a></td>
				</tr>
				<%} %>
			</tbody>
		</table>
</body>
</html>