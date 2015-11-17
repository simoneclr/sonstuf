<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
	<head>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<c:import url="/prefabs/header.jsp"></c:import>
		<link href="../css/style-gianluca.css" rel="stylesheet">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login</title>
	</head>
	<body>
		<div class="login">
			<h2>Login</h2>
			<form class="form-horizontal" method="POST" action="check-login">
				<div class="form-group">
					<label for="username" class="col-sm-2 col-xs-2 control-label">Username</label>
					<div class="col-sm-6 col-xs-6">
						<input type="email" class="form-control" id="username" name="username" placeholder="username">
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-sm-2 col-xs-2 control-label">Password</label>
					<div class="col-sm-6 col-xs-6">
						<input type="password" class="form-control" id="password" name="password" placeholder="password">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-4 col-xs-4 remember_column">
						<div class="checkbox">
								<input name="remember" type="checkbox" value="Remember Me"> Remember Me
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-3 col-xs-2">
						<button type="submit" class="btn btn-default">Entra</button>
					</div>
				</div>
			</form>
		</div>
	</body>

</html>
