<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 페이지</title>
</head>
<body>
	<h1> 회원 가입 </h1>
	<form action="member" method="post">
		ID:<input type="text" name="userId" ><br>
		PW:<input type="text" name="userPw" ><br>
		<input type="hidden" value="signUp" name="action"><br>	
		<button>sign-up</button>
	</form>
	
</body>
</html>