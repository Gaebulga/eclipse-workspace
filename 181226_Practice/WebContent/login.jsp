<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
		<h1> 로그인 페이지 </h1>
		<form action="member" method="post">
			ID:<input type="text" name="userId" ><br>
			PW:<input type="text" name="userPw" ><br>
			<input type="hidden" value="login" name="action"><br>	
			<button>login</button>
		</form>
		
</body>
</html>