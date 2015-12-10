<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:import url="/prefabs/header.jsp"></c:import>
	<link href="../css/style-gianluca.css" rel="stylesheet">
	<link href="../css/datepicker.css" rel="stylesheet">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Registrati</title>

</head>
	<body>

		<c:import url="/prefabs/navbar.jsp"></c:import>

		<div class="container">
			<div class="row">
				<div class="col-md-10 col-md-offset-1">
					<h2>Registrati</h2>
					<hr class="colorgraph">
				</div>
			</div>
			<div class="row">
				<div class="col-md-10 col-md-offset-1">
					<div class="msg">
					</div>
				</div>
			</div>
			<form id="myForm" action="/RegistrationServlet" name="registerForm">
				<div class="row">
					<input type="hidden" name="op" value="register">
					<div class="form-group col-md-offset-2 col-md-3 col-sm-3 col-sm-offset-2 col-xs-7">
						<label>Nome</label>
						<input type="text" name="name" class="form-control border" id="name">
					</div>
					<div class="form-group col-md-offset-2 col-md-3 col-sm-3 col-sm-offset-2 col-xs-7">
						<label>Cognome</label>
						<input type="text" name="surname" class="form-control border" id="surname">
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-offset-2 col-md-3 col-sm-3 col-sm-offset-2 col-xs-7">
						<label>Data di nascita</label>
						<input type="date" name="birthdate" id="birthdate" class="form-control border">
					</div>
					<div class="form-group col-md-offset-2 col-md-3 col-sm-3 col-sm-offset-2 col-xs-7">
						<label>Email</label>
						<input type="text" name="email" id="email" class="form-control border">
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-offset-2 col-md-3 col-sm-3 col-sm-offset-2 col-xs-7">
						<label>Telefono</label>
						<input type="tel" name="phone" id="phone" class="form-control border">
					</div>
					<div class="form-group col-md-offset-2 col-md-3 col-sm-3 col-sm-offset-2 col-xs-7">
						<label>Password</label>
						<input type="password" name="password1" class="form-control border" id="password1">
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-offset-2 col-md-3 col-sm-3 col-sm-offset-2 col-xs-7">
						<label>Conferma password</label>
						<input type="password" name="password2" class="form-control border" id="password2">
						<span id="confirmMessage" class="confirmMessage"></span>
					</div>
					<div class="form-group col-md-offset-3 col-md-2 col-sm-3 col-sm-offset-2 col-xs-7">
						<button id="button_submit_register"  class="btn btn-success" >Registrati</button>
					</div>
				</div>
			</form>
		</div>

		<c:import url="/prefabs/footer.jsp"></c:import>


		<script src="../js/gianluca/bootstrap-datepicker.js"></script>
		<script src="../js/gianluca/register.js"></script>


	</body>
</html>
