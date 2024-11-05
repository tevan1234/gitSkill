<%@page import="javaweb.model.dto.ProductDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ProductDto productDto = (ProductDto)request.getAttribute("productDto");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>新增產品</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<link rel="stylesheet" href="/javaweb/css/buttons.css">
	</head>
	<body style="padding: 15px">
		<table>
			<td valign="top">
				<form class="pure-form" method="post" action="/javaweb/product/add">
					<fieldset>
						<legend>上架產品</legend>
						產品名稱:<input type="text" name="product_name" value="<%=productDto.getProduct_name() %>"/><p /> 
						產品價格:<input type="text" name="price" value="<%=productDto.getPrice() %>"/><p />
						產品庫存:<input type="text" name="stock_quantity" value="<%=productDto.getStock_quantity() %>"/><p />
						<button type="submit" class="button-success pure-button">上架</button>
					</fieldset>
				</form>
			</td>
		</table>
	</body>
</html>