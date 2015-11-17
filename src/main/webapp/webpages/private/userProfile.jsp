<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
	<c:import url="/prefabs/header.jsp"></c:import>
	<title>User Profile | Sonstuf</title>
</head>

<body>

	<c:import url="/prefabs/navbar.jsp"></c:import>

	<div class="container">

		<div class="row" style="margin-bottom: 30px; margin-top: 30px">
			<div class="col-md-12">
				<h1>Roberto 'Amumu' Fellin</h1>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<img src="http://placehold.it/250x300">
			</div>
			<div class="col-md-9">
				<h4><strong>Data di nascita:</strong> 21/12/2012</h4>
				<h4><strong>Email:</strong> rf.garenlol@dambel.zum</h4>
				<h4><strong>Telefono:</strong> Non te lo dico gné gné!</h4>
				<br>
				<h4>
					<strong>Rating O:</strong>
						<input id="rating-o" type="number" class="rating" min=0 max=5 step=1 data-size="sm">
				</h4>
				<h4>
					<strong>Rating R:</strong>
					<input id="rating-r" type="number" class="rating" min=0 max=5 step=1 data-size="sm">
				</h4>
			</div>
		</div>

		<ul class="nav nav-tabs">
			<li class="active"><a data-toggle="tab" href="#requests">I tuoi annunci</a></li>
			<li><a data-toggle="tab" href="#jobs">I tuoi lavori</a></li>
		</ul>

		<div class="tab-content">
			<div id="requests" class="tab-pane fade in active">

				<div class="row">
					<div class="panel panel-default">
						<div class="panel-heading">Titolo richiesta</div>
						<div class="panel body" style="overflow: auto; margin-bottom: 0px">
							<img src="http://placehold.it/150x150" style="float: left; margin-right: 10px">
							<p>
								"Lorem ipsum dolor sit amet, consectetur adipiscing elit,
								sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
								Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip
								ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit
								esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat
								non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
							</p>
						</div>
					</div>
				</div>
			</div>

			<div id="jobs" class="tab-pane fade in">

			</div>
		</div>

	</div>

	<script>
		//Inizializza i rating
		$("#rating-o").rating({'showCaption': false,
			'showClear': false,
			'readonly': true
		}).rating('update', 5);

		$("#rating-r").rating({'showCaption': false,
			'showClear': false,
			'readonly': true
		}).rating('update', 4);
	</script>

</body>
</html>
