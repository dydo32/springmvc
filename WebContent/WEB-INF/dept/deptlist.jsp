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
		<h1>�μ���Ϻ���</h1>
		<hr/>

		<table border="1">
			<thead>
				<tr bgColor="#ffff99">
					<th>�μ���ȣ</th>
					<th>�μ��̸�</th>
					<th>�μ���ġ</th>
					<th>�μ���ȭ��ȣ</th>
					<th>������</th>
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
					<td><a href="/springmvc/dept/delete.do?deptno=<%=dept.getDeptNo()%>">����</a></td>
				</tr>
				<%} %>
			</tbody>
		</table>
</body>
</html>