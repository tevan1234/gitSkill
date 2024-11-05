<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<link rel="stylesheet" href="<%= request.getContextPath() %>/css/buttons.css">
		<link rel="stylesheet" href="<%= request.getContextPath() %>/css/bootstrap.min.css">
	</head>
	<body>
		<nav class="navbar navbar-expand-lg bg-body-tertiary" style="background-color: #dddddd">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">保單查詢系統</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNav"
					aria-controls="navbarNav" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#">首頁</a></li>
						<li class="nav-item"><a class="nav-link" href="#">查詢保單</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="#">Pricing</a>
						</li>
						<li class="nav-item"><a class="nav-link disabled"
							aria-disabled="true">Disabled</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</body>
</html>