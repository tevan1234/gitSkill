<%@page import="shoppingSite.model.dto.ProductDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %> 
<%
	List<ProductDto> productDtos = (List<ProductDto>)request.getAttribute("productDtos");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Product</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<link rel="stylesheet" href="/javaweb/css/buttons.css">
	</head>
	<body>
		<div style="padding: 15px">
			<form class="pure-form">
				<fieldset>
					<legend>Product 列表</legend>
					產品名稱 : <input type="text" name="product_name" placeholder="請輸入 產品名稱" required /><p /> 
					產品價錢: <input type="text" name="price" placeholder="請輸入 產品價錢" required /><p /> 
					產品庫存: <input type="text" name="stock_quantity" placeholder="請輸入 產品庫存" required /><p />
					
					<button type="submit" class="pure-button pure-button-primary">上架</button>	  
				</fieldset>
			</form>
		</div>
	</body>
</html>