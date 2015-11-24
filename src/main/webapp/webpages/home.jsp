<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<c:import url="/prefabs/header.jsp"></c:import>
		<link href="../css/style-gianluca.css" rel="stylesheet">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Home | Sonstuf</title>
	</head>

	<body>
		<c:import url="/prefabs/navbar.jsp"></c:import>

		<div class="container" id="home_main_container">
			<div class="row">
				<div class="col-md-offset-1 col-md-10">
					<img class="img-responsive" src="http://placehold.it/1050x400"/>
				</div>
			</div>

			<br>

			<div class="row" id="row1">
				<div class="col-md-offset-2 col-md-4 col-sm-offset-2 col-sm-4 col-xs-offset-2 col-xs-4" >
					<h3>VISUALIZZA LISTA ANNUNCI</h3>
				</div>

				<div class="col-md-offset-2 col-md-4 col-sm-offset-2 col-sm-4 col-xs-offset-2 col-xs-4">
					<button class="btn btn-default orange-circle-button" href="">
						<span class="glyphicon glyphicon-arrow-right"></span>
						<span class="orange-circle-greater-than"></span>
					</button>
				</div>
			</div>

			<br>

			<div class="row" id="row2">
				<div class="col-md-offset-2 col-md-4 col-sm-offset-2 col-sm-4 col-sm-4 col-xs-offset-2 col-xs-4">
					<h3>INSERISCI RICHIESTA</h3>
				</div>

				<div class="col-md-offset-2 col-md-4 col-sm-offset-2 col-sm-4 col-xs-offset-2 col-xs-4 ">
					<button class="btn btn-default orange-circle-button" href="">
						<span class="glyphicon glyphicon-arrow-right"></span>
						<span class="orange-circle-greater-than"></span>
					</button>
				</div>
			</div>
		</div>

		<c:import url="/prefabs/footer.jsp"></c:import>
	</body>
</html>
