<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
	<head>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<c:import url="../prefabs/header.jsp"></c:import>
		<link href="../css/style-gianluca.css" rel="stylesheet">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="/css/style-simone.css">
		<script src="/js/simone/login.js"></script>
		<title>Login</title>
	</head>

	<body>
		<c:import url="../prefabs/navbar.jsp"></c:import>

		<div class="login">
			<div class="panel panel-default" >
				<div class="panel-heading">
					<div class="panel-title text-center">
						<h2>Login</h2>
					</div>
				</div>

				<div class="panel-body" id="panel_body_login">

					<div class="alert alert-danger fade in hidden" id="error-alert">
						<strong>Errore!</strong>
						<span id="error-message"></span>
					</div>

					<form name="form-login" class="form-horizontal" action="/AuthenticationServlet">
						<div class="form-group">
							<label for="userName" class="col-md-offset-1 col-md-2 col-sm-3 col-sm-offset-1 col-xs-10 control-label">
								Username
							</label>
							<div class="col-md-5 col-md-offset-1  col-sm-6 col-xs-10">
								<input class="form-control" id="userName" name="userName" placeholder="username">
							</div>
						</div>

						<div class="form-group">
							<label for="password" class="col-md-offset-1 col-md-2 col-sm-3 col-sm-offset-1 col-xs-10 control-label">
								Password
							</label>
							<div class="col-md-5 col-md-offset-1  col-sm-6 col-xs-10">
								<input type="password" class="form-control" id="password" name="password" placeholder="password">
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-5 col-md-offset-1 col-sm-6 col-sm-offset-1 col-xs-12 remember_column">
								<div class="checkbox">
										<input name="rememberMe" type="checkbox" value="Remember Me"> Remember Me
								</div>
								<input type="hidden" name="op" value="authenticate">
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-3 col-md-offset-8 col-sm-2 col-sm-offset-6 col-xs-5">
								<button type="submit" id="submit_login" class="btn btn-primary btn-sm">Accedi</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</body>

</html>
