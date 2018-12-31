<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>FUCK</title>
</head>
<body>
	
	<!-- 스크립틀릿? html안에서 java코드를 이용하도록  '<'+'%' -->
	<%-- <% String id=(String)session.getAttribute("userId"); %>
	
	<% if(id!=null){ %>
	<h1><%=id %></h1>
	<%} %> --%>
	
	<!-- EL을 사용해보자 -->
	<!-- 미리 변수선언할 필요가 없고, java를 사용할 필요가 없다.이 부분은 공식 -->
	<!-- 스크립틀릿을 사용하면 빈값인 경우 NULL이 나오지만, EL은 빈 값이 안나오게 할 수 있으므로 장점이 될 수 있다. -->
	<h1>${sessionScope.userId}</h1>
	
	<form action="member" method="post">
		<!-- controler방식 : 별로 좋은 방법이 아님. -->
		<!-- 그래서 나온 방법이 메서드()마다 받을 수 있게 하는 것.  스프링이 이걸??okok -->
		<!-- 액션을 여러개 주고 싶을 때, hidden 타입을 사용하여,  if문을 통해 여러가지 action을 취할 수 있게 된다. -->
		<input type="hidden" name="action" value="join">
		ID:<input type="text" name="userId"><br>
		PW:<input type="text" name="userPw"><br><br>
		<button> 가입하기 </button>
	</form>

	<form action="member" method="post">	<!-- form에서 click 하면 세션 비울수 있도록 -->
		<input type="hidden" name="action" value="logout">
		<button>세션 비우기</button>
	</form>

</body>
</html>