<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Welcome to Page</title>
</head>
	<!-- parameter를 받아서 보내기 위해 HTML이 아닌 jsp을 사용한다 -->
<body>
	
	<!-- 기본적으로 Object 타입으로 받아오기 때문에 타입에 맞춰 캐스팅(형변환) -->
	<% String id = (String)session.getAttribute("id"); %>
	<h1><%=id%>!! Welcome !!</h1>



</body>
</html>