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
<div class="container centered">
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
			<div class="col-xs-4 text-center">
				<small><cite> <i class="glyphicon glyphicon-map-marker"></i>Dambel</cite></small>
				<small><cite> <i class="glyphicon glyphicon-time"></i>Sabato mattina</cite></small>
				<small><cite> <i class="glyphicon glyphicon-user"></i>Gianlu94</cite></small>
			</div>
		</div>
	</div>
</div>

<hr>
<div class="container inCorso">
	<div class="[ col-xs-12 col-sm-offset-2 col-sm-8 ]">
		<ul class="offer-list">
			<li class="offer">
				<div class="box-shadow row">
					<div class="offerDate col-xs-3">
						<time datetime="2015-12-22">22 dicembre ore 20:00</time>
					</div>
					<div class="col-xs-3">
						<h2 class="userName">FellinR</h2>
					</div>
					<div class="userRank col-xs-3">
						* * * * *
						<!--
						<div data-content="" class="rating-container rating-gly-star">
							<div style="width: 100%;" data-content="" class="rating-stars"></div>
							<input id="rating-o" class="rating form-control hide" min="0" max="5" step="1"
								   data-size="sm" type="number"></div>
								   -->
					</div>
					<div class="social col-xs-3">
						<ul>
							<li class="assign">
								<img class="icon"
								     src="http://media.licdn.com/mpr/mpr/shrinknp_400_400/p/5/005/067/1a9/39f45b1.jpg">
							</li>
						</ul>
					</div>
				</div>
				</li>


		</ul>
	</div>
</div>

<br>
<br>

<c:import url="/prefabs/footer.jsp"></c:import>
</body>
</html>
