<%@ page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Random random = new Random();
int n1 = random.nextInt(10); // 0~9 的隨機數
int n2 = random.nextInt(10); // 0~9 的隨機數
int n3 = random.nextInt(10); // 0~9 的隨機數
int n4 = random.nextInt(10); // 0~9 的隨機數
%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Lotto 電腦選號</title>
	</head>
	<body>
		<%=n1%>
		<%=n2%>
		<%=n3%>
		<%=n4%>
	</body>
	<h1>
		<%=session.getId() %>
	</h1>
</html>