<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:import url="/prefabs/header.jsp"></c:import>
	<link href="/css/enricoStyle.css" rel="stylesheet">

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Dettaglio richiesta</title>

</head>
<body>
<c:import url="/prefabs/navbar.jsp"></c:import>
<nav class="navbar navbar-fixed-top request">
	<div class="container">
		<div class="panel box-shadow">
			<div class="row">
				<div class="col-xs-4">

				</div>
			</div>
			<div class="row">
				<div class="col-xs-4">
					<img class="icon img-rounded" src="http://image.freepik.com/free-photo/grass--garden_19-119630.jpg">
				</div>
				<div class="col-xs-4">
					<h3 class="title">
						Taglio erba
					</h3>
					<br>

					<div class="description">
						Cerco qualcuno che possa tagliare l'erba; <br>
						Ho tosaerba da mettere a disposizione. <br>
						Prato piano di 1000 m^2 <br>
						O.o
					</div>
				</div>
				<div class="col-xs-4 text-center" style="padding: 10px">
					<small><cite> <i class="glyphicon glyphicon-map-marker"></i>Dambel</cite></small>
					<small><cite> <i class="glyphicon glyphicon-time"></i>Sabato mattina</cite></small>
					<small><cite> <i class="glyphicon glyphicon-user"></i>Gianlu94</cite></small>
				</div>
			</div>
		</div>
	</div>
</nav>

<div class="container centered status">
	<div class="inCorso">
		<c:forEach var="i" begin="1" end="5">
			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<strong>Offerta</strong>
						</div>
						<div class="panel body" style="overflow: auto; margin-bottom: 0px">
							<div class="col-xs-2">
								<img src="http://placehold.it/150x150" style="float: left; margin-right: 10px">
							</div>
							<div class="col-xs-8">
								<p>
									"Lorem ipsum dolor sit amet, consectetur adipiscing elit,
									sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
									Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip
									ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit
									esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat
									non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
								</p>
							</div>
							<div class="col-xs-2">
								<small><cite> <i class="glyphicon glyphicon-ok"></i>Incarica</cite></small>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>

<br>
<br>

<c:import url="/prefabs/footer.jsp"></c:import>
</body>
</html>
