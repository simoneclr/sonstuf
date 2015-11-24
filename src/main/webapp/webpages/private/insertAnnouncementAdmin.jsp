<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:import url="/prefabs/header.jsp"></c:import>


	<link href="/css/style-roberto.css" rel="stylesheet">

	<script src="/js/roberto/insertAnnouncementAdmin.js"></script>

	<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">
	<script type="text/javascript" src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>inserisci annuncio Admin</title>

</head>
<body>

<c:import url="/prefabs/navbar.jsp"></c:import>

<div class="container">
	<div class="row">
		<div class="col-md-10 col-md-offset-1">
			<h2>Seleziona utente</h2>
			<hr class="colorgraph">
		</div>
	</div>

	<br>

	<div class="row">
		<div class="col-md-offset-1 col-md-3">
			<label>Nome</label>
			<input type="text" name="name" class="form-control" id="name" value="">
		</div>
		<div class="col-md-offset-0,5 col-md-3">
			<label>Cognome</label>
			<input type="text" name="surname" class="form-control" id="surname" value="">
		</div>
		<div class="col-md-offset-0,5 col-md-3">
			<label>Telefono</label>
			<input type="tel" name="telephone" class="form-control" id="telephone" value="">
		</div>
	</div>

	<br>
	<div class="row">
		<div class="col-md-offset-1 col-md-3">
			<label>Email</label>
			<input type="email" name="email" class="form-control" id="email" value="">
		</div>
		<div class="col-md-offset-0,5 col-md-3">
			<label>Data di nascita</label>
			<input type="date" name="birthdate" class="form-control" id="birthdate" value="">
		</div>

		<div class="col-md-offset-2 col-md-2">
			<button class="btn btn-success" style="margin-top: 25px" id="cerca">Cerca </button>
		</div>
	</div>

	<br>
	<br>

	<div class="list row">
		<div class="col-md-offset-1 col-md-10">
			<div class="col-md-offset-4 col-md-2">
				<button class="btn btn-success" style="margin-top: 25px" id="registra">Registra Utente e Inserisci Annuncio </button>
			</div>
		</div>
	</div>

	<br>
	<br>

	<div class="list row" id="rowTable">
		<div class="col-md-offset-1 col-md-10">

			<div class="table-responsive">
				<table id="myTable" class="display table" width="100%" >

					<thead>
					<tr>
						<th>Nome</th>
						<th>Cognome</th>
						<th>Telefono</th>
						<th>Email</th>
						<th>Data di nascita</th>
					</tr>
					</thead>
					<tbody id="bodyTable">
					<script id="request-template" type="text/x-handlebars-template">
						<tr id="{{id}}">
							<td>{{name}}</td>
							<td>{{surname}}</td>
							<td>{{telephone}}</td>
							<td>{{email}}</td>
							<td>{{birthdate}}</td>

						</tr>
					</script>

					</tbody>
				</table>
			</div>


		</div>
	</div>

</div>

<script>
	$(document).ready(function(){
		$('#myTable').dataTable();
	});
</script>

<c:import url="/prefabs/footer.jsp"></c:import>

</body>
</html>
