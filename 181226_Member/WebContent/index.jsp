<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h1> 회원가입 페이지 </h1>
		
		<!-- input type이 3개이면   파라미터도 3개라는 뜻 -->
		<form action="member" method="post">
			ID:<input type="text" name="userId">
			<font color="red">${requestScope.message}</font>
			<br>
			PW:<input type="password" name="userPw"><br>
			<input type="hidden" value="signUp" name="action">
			<button>가입하기</button>
		</form>



</body>
</html>