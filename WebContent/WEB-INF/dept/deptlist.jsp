<%@page import="dept.dto.DeptDTO"%>
<%@page import="java.util.List"%>
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
		ArrayList<DeptDTO> deptlist = (ArrayList<DeptDTO>)request.getAttribute("deptlist");
		int size = deptlist.size();
		DeptDTO dept = null;
	%>
		<%-- <jsp:include page="search.jsp"/> --%>
		<h1>부서목록보기</h1>
		<hr/>

		<table border="1">
			<thead>
				<tr bgColor="#ffff99">
					<th>부서번호</th>
					<th>부서이름</th>
					<th>부서위치</th>
					<th>부서전화번호</th>
					<th>관리자</th>
				</tr>
			</thead>
			<tbody>
				<%for(int i=0; i<size; i++){ 
				dept = deptlist.get(i);%>
				<tr>
					<td><a href="/serverweb/emp/read.do?id=<%=dept.getDeptNo()%>&action=READ"><%=dept.getDeptNo() %></a></td>
					<td><%=dept.getDeptName() %></td>
					<td><%=dept.getLoc() %></td>
					<td><%=dept.getTel() %></td>
					<td><%=dept.getMgr() %></td>
					<td><a href="/springmvc/dept/delete.do?deptno=<%=dept.getDeptNo()%>">삭제</a></td>
				</tr>
				<%} %>
			</tbody>
		</table>
</body>
</html>