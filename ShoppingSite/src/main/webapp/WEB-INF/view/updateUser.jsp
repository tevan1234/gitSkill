<%@page import="shoppingSite.model.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	UserDto userDto = (UserDto)request.getAttribute("userDto");
%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Update User Information</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	<link rel="stylesheet" href="/ShoppingSite/css/buttons.css">
	</head>
	<body style="padding: 15px">
		<form class="pure-form" method="post" action ="/ShoppingSite/user/update">
			<fieldset>
				<legend>User 資料更新</legend>
				序號: <input type="text" name="userId" value="<%=userDto.getUid() %>" readonly /><p />
				帳號: <input type="text" name="username" value="<%=userDto.getAccount() %>" readonly /><p />
				啟用: <input type = "radio" name="active" value="true" <%=userDto.isActive() ? "checked" : ""%>>True
					  <input type = "radio" name="active" value="false" <%=userDto.isActive() ? "" : "checked"%>>False<p />
				手機: <input type="text" name="phone" placeholder="請輸入 phone" required/><p />
				電郵: <input type="email" name="email" placeholder="請輸入 email" required/><p />				
				權限: <select name="role">
							<option value=1 <%=userDto.getRole() == 1?"selected":"" %>>ADMIN</option>
							<option value=2 <%=userDto.getRole() == 2?"selected":"" %>>SELLER</option>
							<option value=3 <%=userDto.getRole() == 3?"selected":"" %>>BUYER</option>
					  </select><p />
				<button type="submit" class="button-success pure-button">Update</button>
			</fieldset>
		</form>
	</body>
</html>