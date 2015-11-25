<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:import url="/prefabs/header.jsp"></c:import>
	<link href="../css/style-gianluca.css" rel="stylesheet">
	<script src="../js/gianluca/register.js"></script>
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
			<form name="myForm" onsubmit="return validateForm()">
				<div class="row">
					<div class="form-group col-md-offset-2 col-md-3 col-sm-3 col-sm-offset-2 col-xs-7">
						<label>Nome</label>
						<input type="text" name="name" class="form-control" id="name">
					</div>
					<div class="form-group col-md-offset-2 col-md-3 col-sm-3 col-sm-offset-2 col-xs-7">
						<label>Cognome</label>
						<input type="text" name="surname" class="form-control" id="surname">
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-offset-2 col-md-3 col-sm-3 col-sm-offset-2 col-xs-7">
						<label>Data di nascita</label>
						<input type="tel" name="birthdate" id="birthdate" class="form-control">
					</div>
					<div class="form-group col-md-offset-2 col-md-3 col-sm-3 col-sm-offset-2 col-xs-7">
						<label>Email</label>
						<input type="text" name="email" id="email" class="form-control">
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-offset-2 col-md-3 col-sm-3 col-sm-offset-2 col-xs-7">
						<label>Telefono</label>
						<input type="tel" name="phone" id="phone" class="form-control">
					</div>
					<div class="form-group col-md-offset-2 col-md-3 col-sm-3 col-sm-offset-2 col-xs-7">
						<label>Password</label>
						<input type="password" name="password1" class="form-control" id="password1">
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-offset-2 col-md-3 col-sm-3 col-sm-offset-2 col-xs-7">
						<label>Conferma password</label>
						<input type="password" name="password2" class="form-control" id="password2">
					</div>
					<div class="form-group col-md-offset-2 col-md-2 col-sm-3 col-sm-offset-2 col-xs-7">
						<button id="button_submit_register"  class="btn btn-success" >Registrati</button>
					</div>
				</div>
			</form>
		</div>

		<c:import url="/prefabs/footer.jsp"></c:import>

	</body>
</html>
