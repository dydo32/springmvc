<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>���������� ������ ��</h1>
	<hr/>
	<h2>jsp�ڵ�� ����ϱ�:<%=request.getAttribute("msg") %></h2>
	<h2>EL�� ����ϱ�: ${msg }</h2>
</body>
</html>