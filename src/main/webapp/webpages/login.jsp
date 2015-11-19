<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
	<head>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<c:import url="../prefabs/header.jsp"></c:import>
		<link href="../css/style-gianluca.css" rel="stylesheet">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login</title>
	</head>
	<body>
		<c:import url="../prefabs/navbar.jsp"></c:import>
		<div class="login">
			<h2>Login</h2>
			<form class="form-horizontal" method="POST" action="check-login">
				<div class="form-group">
					<label for="userName" class="col-md-2 col-sm-3 col-xs-10 control-label">Username</label>
					<div class="col-md-5 col-md-offset-1  col-sm-6 col-xs-10">
						<input class="form-control" id="userName" name="userName" placeholder="username">
					</div>
				</div>
				<div class="form-group">
					<label for="password" class=" col-md-2 col-sm-3 col-xs-10 control-label">Password</label>
					<div class="col-md-5 col-md-offset-1  col-sm-6 col-xs-10">
						<input type="password" class="form-control" id="password" name="password" placeholder="password">
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-5 col-sm-6 col-xs-12 remember_column">
						<div class="checkbox">
								<input name="rememberMe" type="checkbox" value="Remember Me"> Remember Me
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-3 col-xs-2">
						<button type="submit" class="btn btn-primary btn-md">Accedi</button>
					</div>
				</div>
			</form>
		</div>

		<c:import url="../prefabs/footer.jsp"></c:import>

	</body>

</html>
