<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
	<c:import url="/prefabs/header.jsp"></c:import>
	<link	href="/css/style-simone.css" rel="stylesheet">
	<script src="/js/simone/userprofile.js"></script>
	<title>Roberto 'Amumu' Fellin | Sonstuf</title>
</head>

<body>

	<c:import url="/prefabs/navbar.jsp"></c:import>

	<div class="container">

		<div class="row" style="margin-bottom: 30px; margin-top: 30px">
			<div class="col-md-9">
				<h1 id="ucname">Roberto 'Amumu' Fellin</h1>
			</div>

			<div class="col-md-3">
				<button type="button" class="btn btn-info btn-block btn-lg" data-toggle="modal"
								data-target="#usettings" style="margin-top: 16px;">
					<span class="glyphicon glyphicon-wrench"></span>
					Impostazioni profilo
				</button>
			</div>
		</div>

		<!--User settings modal-->
		<div id="usettings" class="modal fade" role="dialog">
			<div class="modal-dialog modal-lg">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Impostazioni profilo</h4>
					</div>
					<div class="modal-body">
						<form>

						</form>
					</div>
				</div>

			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<img src="http://placehold.it/250x300">
			</div>
			<div class="col-md-9">
				<h4><strong>Data di nascita:</strong> <span id="bdate">21/12/2012</span></h4>
				<h4><strong>Email:</strong> <span id="email">rf.garenlol@dambel.zum</span></h4>
				<h4><strong>Telefono:</strong> <span id="telnum">Non te lo dico gné gné!</span></h4>
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

		<hr class="colorgraph" style="margin-top: 100px">

		<ul class="nav nav-tabs">
			<li class="active"><a data-toggle="tab" href="#requests">I tuoi annunci</a></li>
			<li><a data-toggle="tab" href="#jobs">I tuoi lavori</a></li>
		</ul>

		<div class="tab-content" style="padding-top: 10px;">
			<div id="requests" class="tab-pane fade in active">

				<c:forEach var="i" begin="1" end="5">
					<div class="row">
						<div class="col-md-12">
							<div class="panel panel-default">
								<div class="panel-heading">
									<strong>Titolo Richiesta</strong>
								</div>
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
				</c:forEach>

			</div>

			<div id="jobs" class="tab-pane fade in">

				<c:forEach var="i" begin="1" end="5">
					<div class="row">
						<div class="col-md-12">
							<div class="panel panel-default">
								<div class="panel-heading">
									<strong>Titolo Richiesta</strong>
								</div>
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
				</c:forEach>

			</div>
		</div>

	</div>

	<script>
		//Inizializza i rating
		$("#rating-o").rating({'showCaption': false,
			'showClear': false,
			'readonly': true
		});

		$("#rating-r").rating({'showCaption': false,
			'showClear': false,
			'readonly': true
		});
	</script>

</body>
</html>
