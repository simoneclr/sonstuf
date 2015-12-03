<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
	<c:import url="/prefabs/header.jsp"></c:import>
	<title>Index</title>
</head>

<body>

	<c:import url="/prefabs/navbar.jsp"></c:import>

	<div class="container">
		<h1>Sonstuf.com</h1>
		<h3>Risorse disponibili</h3>

		<br>

		<ul>
			<li>
				<a href="/webpages/home.jsp">Home</a>
			</li>
			<li>
				<a href="/webpages/private/inserisciRichiesta.jsp">Inserimento Richiesta</a>
			</li>
			<li>
				<a href="/webpages/login.jsp">Login</a>
			</li>
			<li>
				<a href="/webpages/myOfferDetail.jsp">Dettaglio offerta</a>
			</li>
			<li>
				<a href="/webpages/myRequestDetail.jsp">Dettaglio mia richiesta</a>
			</li>
			<li>
				<a href="/webpages/register.jsp">Registrazione</a>
			</li>
			<li>
				<a href="/webpages/requestDetail.jsp">Dettaglio richiesta altrui</a>
			</li>
			<li>
				<a href="/webpages/requestList.jsp">Lista richieste</a>
			</li>
			<li>
				private/
				<ul>
					<li>
						<a href="/webpages/private/adminMenu.jsp">Menu Amministratore</a>
					</li>
					<li>
						<a href="/webpages/private/confirmsInsertionJobs.jsp">Conferma inserimento lavoro</a>
					</li>
					<li>
						<a href="/webpages/private/jobsConfirmsAccepted.jsp">Conferma accettazione lavoro</a>
					</li>
					<li>
						<a href="/webpages/private/userProfile.jsp">Profilo utente</a>
					</li>
				</ul>
			</li>
		</ul>
	</div>

</body>
</html>