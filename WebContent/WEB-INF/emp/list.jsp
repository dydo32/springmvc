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
		<h1>ȸ����Ϻ���(jsp�� �и�)</h1>
		<hr/>
	
		<table border="1">
			<thead>
				<tr bgColor="#ffff99">
					<th>���̵�</th>
					<th>��й�ȣ</th>
					<th>�̸�</th>
					<th>�ּ�</th>
					<th>�Ի���</th>
					<th>���</th>
					<th>����Ʈ</th>
					<th>�μ���ȣ</th>
					<th>����</th>
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
					<td><a href="/serverweb/emp/delete.do?info=test&id=<%=user.getId()%>">����</a></td>
				</tr>
				<%} %>
			</tbody>
		</table>
</body>
</html>