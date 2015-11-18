<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:import url="/prefabs/header.jsp"></c:import>
	<link href="/css/enricoStyle.css" rel="stylesheet">
	<script src="/js/enrico/myOfferDetail.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Dettaglio offerta</title>

</head>
<body>
<c:import url="/prefabs/navbar.jsp"></c:import>
<nav class="navbar navbar-fixed-top request">
	<div class="container">
		<div id="requestContainer" class="panel box-shadow">
			<script id="request" type="text/x-handlebars-template">
				<div class="row">
					<div class="col-xs-4">
						<img class="icon img-rounded"
						     src="{{REQUEST_IMAGE}}">
					</div>
					<div class="col-xs-4">
						<h3 class="title">
							{{REQUEST_TITLE}}
						</h3>
						<br>

						<div class="description">
							{{REQUEST_DESCRIPTION}}
						</div>
					</div>
					<div class="col-xs-4 text-center" style="padding: 10px">
						<small><cite> <i class="glyphicon glyphicon-map-marker"></i>{{PLACE}}</cite></small>
						<small><cite> <i class="glyphicon glyphicon-time"></i>{{TIME}}</cite></small>
						<small><cite> <i class="glyphicon glyphicon-user"></i><span class="userName"></span></cite></small>
					</div>
				</div>
			</script>

		</div>
	</div>
</nav>

<div class="container centered status">
	<div class="inCorso hidden">
		<div class="col-xs-4"></div>
		<div class="col-xs-4">
			<p>hai dato la tua disponibilità per questa richiesta;</p>

			<p>attendi che <span class="userName"></span> scelga un incaricato.</p>
		</div>
		<div class="col-xs-4"></div>
	</div>
	<div class="inAttesaDiValutazione hidden">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default box-shadow">
					<div class="panel-heading">
						<strong>Valuta <span class="userName"></span></strong>
					</div>
					<div class="panel body" style="overflow: auto; margin-bottom: 0px">
						<div class="col-xs-2">
							<img src="http://placehold.it/150x150"
							     style="float: left; margin-right: 10px">
						</div>
						<div class="col-xs-6">
							<p>
								"Lorem ipsum dolor sit amet, consectetur adipiscing elit,
								sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
								Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi
								ut aliquip
								ex ea commodo consequat. Duis aute irure dolor in reprehenderit in
								voluptate velit
								esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
								cupidatat
								non proident, sunt in culpa qui officia deserunt mollit anim id est
								laborum."
							</p>
						</div>
						<div class="col-xs-4">

							<strong>Valuta come è stato il rapporto con <span class="userName"></span>:</strong>

							<p>
								<input id="rating-o" type="number" class="rating" min=0 max=5 step=1
								       data-size="sm">
												<textarea id="comment" placeholder="commento" rows="4"
												          cols="50"></textarea>
							</p>
							<button type="submit" class="btn btn-default">Spedisci</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="done hidden">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default box-shadow">
					<div class="panel-heading">
						<strong>Hai valutato <span class="userName"></span></strong>
					</div>
					<div class="panel body" style="overflow: auto; margin-bottom: 0px">
						<div class="col-xs-2">
							<img src="http://placehold.it/150x150"
							     style="float: left; margin-right: 10px">
						</div>
						<div class="col-xs-6">
							<p>
								"Lorem ipsum dolor sit amet, consectetur adipiscing elit,
								sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
								Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi
								ut aliquip
								ex ea commodo consequat. Duis aute irure dolor in reprehenderit in
								voluptate velit
								esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
								cupidatat
								non proident, sunt in culpa qui officia deserunt mollit anim id est
								laborum."
							</p>
						</div>
						<div class="col-xs-4">
							<strong>Hai valutato<span class="userName"></span>:</strong>
							<input id="rating-oDone" type="number" class="rating" min=0 max=5 step=1
							       data-size="sm">

							<div class="comment">
								<p>
									molto bravo.
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<br>
<br>
</div>

<script>
	//Inizializza i rating
	$("#rating-o").rating({
		'showCaption': true,
		'showClear': false,
		'readonly': false
	}).rating('update', 5);
	$("#rating-oDone").rating({
		'showCaption': false,
		'showClear': false,
		'readonly': true
	}).rating('update', 5);

	$(document).ready(function () {
		var state = 0; //can be 0 ; 1 ; 2
		switch (state) {
			case 0:
				$(".inCorso").removeClass("hidden");
				break;
			case 1:
				$(".inAttesaDiValutazione").removeClass("hidden");
				break;
			case 2:
				$(".done").removeClass("hidden");
				break;
			case 3:
				alert("sorry invalid state");
		}
	});
</script>
<c:import url="/prefabs/footer.jsp"></c:import>
</body>
</html>
