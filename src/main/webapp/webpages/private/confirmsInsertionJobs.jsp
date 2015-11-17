<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:import url="/prefabs/header.jsp"></c:import>
	<link href="/css/style-roberto.css" rel="stylesheet">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Conferma Inserimento</title>

</head>
<body>

<c:import url="/prefabs/navbar.jsp"></c:import>

<br>
<br>
<br>

<div class="container">
	<div class="row">
		<div class="col-md-10 col-md-offset-1">
			<h4>INSERIMENTO EFFETTUATO CON SUCCESSO.</h4>
			<br>
			<p>
				<a href="/webpages/home.jsp" style="color: #002a80"><u>Clicca qui</u></a>
			</p>
			<p>
				per essere reindirizzato alla pagina principale
			</p>

		</div>
	</div>
</div>

<c:import url="/prefabs/footer.jsp"></c:import>

</body>
</html>
