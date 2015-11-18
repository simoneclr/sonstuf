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
<div class="container">
	<div class="well well-xm box-shadow">
		<h1 class="title">
			Taglio erba
		</h1>

		<div class="row">
			<div class="col-md-8">
				<img class="icon img-rounded" src="http://image.freepik.com/free-photo/grass--garden_19-119630.jpg">
			</div>
			<div class="col-ms-4 text-center">
				<div style="padding: 5%;">
					<div class="userInfo text-center" style="padding-top: 10px;">
						<small><cite> <i class="glyphicon glyphicon-map-marker"></i>Dambel</cite></small>
						<small><cite> <i class="glyphicon glyphicon-time"></i>Sabato mattina</cite></small>
						<small><cite> <i class="glyphicon glyphicon-user"></i>Gianlu94</cite></small>
						<small><cite>
							<input id="rating-o" type="number" class="rating" min=0 max=5 step=1 data-size="xs">
						</cite></small>

					</div>
				</div>
			</div>
		</div>
		<div class="row description text-center" style="padding-top: 10px;">
			<div class="col-sm-12">
				<h3>
					Cerco qualcuno che possa tagliare l'erba; <br>
					Ho tosaerba da mettere a disposizione. <br>
					Prato piano di 1000 m^2 <br>
					O.o
				</h3>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-12">
			<div class="panel box-shadow">
				<div class="panel">
					<strong>Offriti</strong>
				</div>
				<div class="well well-xm box-shadow" style="overflow: auto; margin-bottom: 0px">
					<div class="col-xs-3"></div>
					<div class="col-xs-3">
						<h3>desideri aiutare fuffi?</h3>
					</div>
					<div class="col-xs-3" style="padding-top: 20px;">
						<small><cite><i class="glyphicon glyphicon-ok"></i>Accetta</cite></small>
					</div>
					<div class="col-xs-3"></div>
				</div>
			</div>
		</div>
	</div>
</div>

<br>
<br>
</div>
<script>
	$("#rating-o").rating({
		'showCaption': false,
		'showClear': false,
		'readonly': true
	}).rating('update', 5);
</script>
<c:import url="/prefabs/footer.jsp"></c:import>
</body>
</html>
