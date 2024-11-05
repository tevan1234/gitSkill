<%@page import="javaweb.model.dto.ProductDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %> <!-- 核心庫 -->
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %> <!-- 格式化庫 -->
    

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Product</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<link rel="stylesheet" href="/javaweb/css/buttons.css">
	</head>
	<body>
		<!--  menu bar include -->
		<%@include file="/WEB-INF/view/menu.jspf" %>
		
		<!--  body content -->
		<div style="padding: 15px">
			<form class="pure-form" method="post" action="/javaweb/product/add">
				<fieldset>
					<legend>Product 新增</legend>
					產品名稱 : <input type="text" name="product_name" placeholder="請輸入 產品名稱" required /><p /> 
					產品價錢: <input type="text" name="price" placeholder="請輸入 產品價錢" required /><p /> 
					產品庫存: <input type="text" name="stock_quantity" placeholder="請輸入 產品庫存" required /><p />
					
					<button type="submit" class="pure-button pure-button-primary">上架</button>	  
				</fieldset>
			</form>
			<p/>
			<div class="pure-form">
				<fieldset>
					<legend>Product 列表</legend>
					<table border="1">
						<thead>
							<tr>
								<th>ProductId</th><th>產品名稱</th><th>價錢</th><th>庫存數量</th><th>刪除</th>
							</tr>
						</thead>
						<c:forEach var="productDto" items="${ productDtos }">
							<tr>
								<td align="center">${productDto.product_id} </td>
								<td>${productDto.product_name}</td>
								<td align="right">
									<fmt:formatNumber value="${productDto.price}" type="currency" maxFractionDigits="0"/>
								</td>
								<td>${productDto.stock_quantity}</td>
								<td><a href="/javaweb/product/delete?productId=${productDto.product_id}" class="button-error pure-button">刪除</a></td>
							</tr>
						</c:forEach>
					</table>
				</fieldset>
				<!--<a href="/javaweb/product/add" class="button-secondary pure-button">上架新產品</a>-->
			</div>
		</div>
	</body>
</html>