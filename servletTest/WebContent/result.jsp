<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Welcome to Page</title>
</head>
	<!-- parameter�� �޾Ƽ� ������ ���� HTML�� �ƴ� jsp�� ����Ѵ� -->
<body>
	
	<!-- �⺻������ Object Ÿ������ �޾ƿ��� ������ Ÿ�Կ� ���� ĳ����(����ȯ) -->
	<% String id = (String)session.getAttribute("id"); %>
	<h1><%=id%>!! Welcome !!</h1>



</body>
</html>