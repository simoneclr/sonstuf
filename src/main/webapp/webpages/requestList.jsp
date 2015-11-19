<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:import url="/prefabs/header.jsp"></c:import>
	<link href="/css/style-roberto.css" rel="stylesheet">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<script src="/js/roberto/requestList.js"></script>

	<title>Lista richieste</title>

</head>
<body>

<c:import url="/prefabs/navbar.jsp"></c:import>

<div class="container">
	<div class="row">
		<div class="col-md-10 col-md-offset-1">
			<h2>Lista richieste</h2>
			<hr class="colorgraph">
		</div>
	</div>

	<br>

	<div class="row">
		<div class="col-md-offset-1 col-md-2">
			<label>Categoria</label>
			<select class="form-control" id="category">
				<option value="">Tutte le categorie</option>
				<script id="category-template" type="text/x-handlebars-template">
					<option>{{category}}</option>
				</script>
			</select>
		</div>
		<div class="col-md-offset-1 col-md-2">
			<label>Nome Richiedente</label>
			<input type="text" name="name" class="form-control" id="name" value="">
		</div>
		<div class="col-md-offset-1 col-md-2">
			<label>Luogo</label>
			<input type="text" name="place" class="form-control" id="place" value="">
		</div>

		<div class="col-md-offset-1 col-md-2">
			<button class="btn btn-success" style="margin-top: 25px" id="btn">Cerca </button>
		</div>
	</div>

	<br>
	<br>

	<div class="list row" id="list">

	</div>
		<script id="request-template" type="text/x-handlebars-template">
			<div class="request col-md-offset-1 col-md-10" id="{{id}}">

				<div class="row">
					<div class="col-md-12">

						<div class="row">
							<div class="col-sm-6 col-md-3">
								<div><h3>{{category}}</h3>
								</div>
								<img src="../img/{{category}}.jpeg" alt="..." class="imgCategory img-circle img-responsive">
							</div>
							<div class="col-sm-6 col-md-8  summary-profile-position">
								<br>
								<br>
								<br>
								<p class="main-profile-p">
									{{title}}
								</p>
								<small><cite> <i class="glyphicon glyphicon-map-marker"></i>{{place}}</cite></small>
								<small><cite> <i class="glyphicon glyphicon-time"></i>{{time}}</cite></small>
								<small><cite> <i class="glyphicon glyphicon-user"></i>{{name}}</cite></small> <span style="float: right">{{postTimestamp}}</span>

							</div>
						</div>

					</div>
				</div>
			</div>
		</script>


		<!--
		<div class="request col-md-offset-1 col-md-10">

				<div class="row">
					<div class="col-md-12">

							<div class="row">
								<div class="col-sm-6 col-md-3">
									<div><h3>Giardinaggio</h3>
									</div>
									<img src="../img/gardening.jpg" alt="..." class="imgCategory img-circle img-responsive">
								</div>
								<div class="col-sm-6 col-md-8  summary-profile-position">
									<br>
									<br>
									<br>
									<p class="main-profile-p">
										Coltivare le ortensie è un'arte ma per ottenere dei buoni risultati si
										devono assicurare alle piante le condizioni climatiche adeguate ed in questa
										sezione potrete scoprire tutti i segreti per coltivare le ortensie e riconoscere
										dal loro aspetto eventuali problemi che...
									</p>
									<small><cite> <i class="glyphicon glyphicon-map-marker"></i>Dambel</cite></small>
									<small><cite> <i class="glyphicon glyphicon-time"></i>Sabato mattina</cite></small>
									<small><cite> <i class="glyphicon glyphicon-user"></i>Gianlu94</cite></small>



								</div>
							</div>

					</div>
				</div>


		</div>
		-->


</div>

<c:import url="/prefabs/footer.jsp"></c:import>

</body>
</html>
