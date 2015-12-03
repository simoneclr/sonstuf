<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<c:import url="/prefabs/header.jsp"></c:import>
		<link href="../css/style-gianluca.css" rel="stylesheet">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Home | Sonstuf</title>
	</head>

	<body class="body_img">
		<c:import url="/prefabs/navbar.jsp"></c:import>
			<div class = "container container-home">
				<div class="row" id="row1">
					<div class ="col-md-4 col-md-offset-1">
						<h3 class="text_link1">SONSTUF</h3>
						<p class="text_link1">Piattaforma nata con lo scopo di offrire
							un servizio volto a favorire l'incontro tra
							una richiesta di "lavoro" e le possibili disponibilità
							concerni lo stesso.
						</p>
					</div>
					<div class="col-md-4 col-md-offset-1" >
						<p class="text_link2B">VISUALIZZA LISTA ANNUNCI</p>
					</div>
					<div class="col-md-1">
						<a href="requestList.jsp">
							<button class="btn btn-default go_request" href="">
								<span class="glyphicon glyphicon-arrow-right"></span>
							</button>
						</a>
					</div>
				</div>
				<div class = row>
					<div class="col-md-4 col-md-offset-6" >
						<p class="text_link2B">INSERISCI RICHIESTA</p>
					</div>
					<div class="col-md-1">
						<a href="inserisciRichiesta.jsp">
							<button class="btn btn-default go_request">
								<span class="glyphicon glyphicon-arrow-right"></span>
							</button>
						</a>
					</div>
				</div>
			</div>
		<c:import url="/prefabs/footer.jsp"></c:import>
	</body>
</html>
