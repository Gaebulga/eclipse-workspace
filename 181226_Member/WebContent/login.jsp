<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
	<h1>로그인 페이지</h1>
		<form action="member" method="post">
			ID:<input type="text" name="userId">
			<font color="red">${requestScope.message}</font>
			<br>
			PW:<input type="password" name="userPw">
			<br>
			<input type="hidden" value="login" name="action">
			<button>로그-인</button>
		</form>
		
</body>
</html>