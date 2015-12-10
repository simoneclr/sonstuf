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

	<div class="list" id="list">

	</div>
		<script id="request-template" type="text/x-handlebars-template">

				<div class="row" id="{{id}}">
					<div class="col-md-10 col-md-offset-1 col-sm-12">
						<div class="panel panel-default request-panel">
							<div class="panel-heading">
								<div class="row rowR">
									<div class="col-sm-3 col-md-2 col-xs-12">
										<h3 class="panel-title titleR"><strong>{{category}}</strong></h3>
									</div>
									<div class="col-md-8 col-md-offset-2 col-sm-9 col-xs-12">
										<ul class="request-info">
											<li>
												<span class="glyphicon glyphicon-map-marker"></span> {{place}}
											</li>
											<li>
												<span class="glyphicon glyphicon-time"></span>{{time}}
											</li>
											<li>
												<span class="glyphicon glyphicon-user"></span>{{name}}
											</li>
										</ul>
									</div>
								</div>
							</div>
							<div class="panel-body">
								<img src="../img/{{category2}}.jpeg" alt="..." class="imgCategory img-circle img-responsive col-md-3 col-sm-3">
								<div class="main-profile-p col-md-6 col-md-offset-3 col-sm-offset-1 col-sm-8">
									{{title}}
								</div>
								<div class="col-md-2 col-md-offset-10 col-sm-2 col-sm-offset-10 col-xs-4 col-xs-offset-8">
									<p>{{postTimestamp}}</p>
								</div>
							</div>
						</div>

					</div>
				</div>
		</script>
		<br><br><br>

</div>


<c:import url="/prefabs/footer.jsp"></c:import>

</body>
</html>
