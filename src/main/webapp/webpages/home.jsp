<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<c:import url="/prefabs/header.jsp"></c:import>
		<link href="../css/style-gianluca.css" rel="stylesheet">
		<link href="/css/style-simone.css" rel="stylesheet">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Home | Sonstuf</title>
	</head>

	<body class="home-body">
		<c:import url="/prefabs/navbar.jsp"></c:import>

			<div class = "container">
				<div class="jumbotron home-jumbo">

					<div class="row">
						<div class="col-md-12">
							<h1>SONSTUF</h1>
						</div>
					</div>

					<div class="row" style="margin-top: 10px">
						<div class="col-md-4">
							<p>Piattaforma nata con lo scopo di offrire
								un servizio volto a favorire l'incontro tra
								una richiesta di "lavoro" e le possibili disponibilità
								concerni lo stesso.
							</p>
						</div>

						<div class="col-md-1"></div>

						<div class="col-md-6">
							<div class="row">
								<div class="col-md-10 col-sm-10 col-xs-8">
									<p>VISUALIZZA LISTA ANNUNCI</p>
								</div>
								<div class="col-md-2 col-sm-2 col-xs-4">
									<a href="requestList.jsp">
										<button class="btn btn-default go_request" href="">
											<span class="glyphicon glyphicon-arrow-right"></span>
										</button>
									</a>
								</div>
							</div>

							<div class="row" style="margin-top: 30px">
								<div class="col-md-10 col-sm-10 col-xs-8">
									<p>INSERISCI RICHIESTA</p>
								</div>
								<div class="col-md-2 col-sm-2 col-xs-4">
									<a href="private/inserisciRichiesta.jsp">
										<button class="btn btn-default go_request">
											<span class="glyphicon glyphicon-arrow-right"></span>
										</button>
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>

		<c:import url="/prefabs/footer.jsp"></c:import>

	</body>
</html>
