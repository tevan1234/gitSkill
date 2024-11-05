<%@page import="shoppingSite.model.dto.UserDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%! String userRole[] = {"Admin","Seller","Buyer"};
	String getUserRole(int i){
		return userRole[i-1];
	}
%>
<%
	List<UserDto>userDtos = (List<UserDto>)request.getAttribute("userDtos");
%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>User</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<link rel="stylesheet" href="/ShoppingSite/css/buttons.css">
	</head>
	<body style="padding: 15px">
		<form class="pure-form" method="post" action ="/ShoppingSite/user/add">
			<fieldset>
				<legend>User 新增</legend>
				帳號: <input type="text" name="username" placeholder="請輸入 username" required /><p />
				密碼: <input type="text" name="password" placeholder="請輸入 password" required /><p />
				手機: <input type="text" name="phone" placeholder="請輸入 phone" required /><p />
				電郵: <input type="email" name="email" placeholder="請輸入 email" required /><p />
				<button type="reset" class="button-warning pure-button">Reset</button>
				<button type="submit" class="button-success pure-button">Submit</button>	
			</fieldset>
		</form>
		
		<form class="pure-form">
			<fieldset>
				<legend>User 列表</legend>
				<table class="pure-table pure-table-bordered">
					<thead>
						<tr>
							<th>ID</th><th>權限</th><th>帳號</th><th>手機</th><th>郵件</th><th>啟用</th><th>修改</th><th>刪除</th>
						</tr>
					</thead>
					<%for(UserDto userDto : userDtos) { %>
						<tr>
							<td><%=userDto.getUid() %></td>
							<td><%=getUserRole(userDto.getRole())%></td>
							<td><%=userDto.getAccount() %></td>
							<td><%=userDto.getPhone() %></td>
							<td><%=userDto.getMail() %></td>
							<td><%=userDto.isActive() %></td>
							<td><a href="/ShoppingSite/user/get?username=<%=userDto.getAccount() %>" class="button-secondary pure-button">修改</a></td>
							<td><a href="/ShoppingSite/user/delete?userId=<%=userDto.getUid() %>" class="button-error pure-button">刪除</a></td>
						</tr>
					<% } %>
				</table>
			</fieldset>
		</form>
	
	</body>
</html>