<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>FUCK</title>
</head>
<body>
	
	<!-- ��ũ��Ʋ��? html�ȿ��� java�ڵ带 �̿��ϵ���  '<'+'%' -->
	<%-- <% String id=(String)session.getAttribute("userId"); %>
	
	<% if(id!=null){ %>
	<h1><%=id %></h1>
	<%} %> --%>
	
	<!-- EL�� ����غ��� -->
	<!-- �̸� ���������� �ʿ䰡 ����, java�� ����� �ʿ䰡 ����.�� �κ��� ���� -->
	<!-- ��ũ��Ʋ���� ����ϸ� ���� ��� NULL�� ��������, EL�� �� ���� �ȳ����� �� �� �����Ƿ� ������ �� �� �ִ�. -->
	<h1>${sessionScope.userId}</h1>
	
	<form action="member" method="post">
		<!-- controler��� : ���� ���� ����� �ƴ�. -->
		<!-- �׷��� ���� ����� �޼���()���� ���� �� �ְ� �ϴ� ��.  �������� �̰�??okok -->
		<!-- �׼��� ������ �ְ� ���� ��, hidden Ÿ���� ����Ͽ�,  if���� ���� �������� action�� ���� �� �ְ� �ȴ�. -->
		<input type="hidden" name="action" value="join">
		ID:<input type="text" name="userId"><br>
		PW:<input type="text" name="userPw"><br><br>
		<button> �����ϱ� </button>
	</form>

	<form action="member" method="post">	<!-- form���� click �ϸ� ���� ���� �ֵ��� -->
		<input type="hidden" name="action" value="logout">
		<button>���� ����</button>
	</form>

</body>
</html>