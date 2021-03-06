<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
	<head>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<c:import url="/prefabs/header.jsp"></c:import>
		<script src="/js/roberto/inserisci-richiesta.js"></script>
		<script src="/js/simone/request.js"></script>

		<!--
		<link href="/css/style-gianluca.css" rel="stylesheet">
		-->
		<link rel="stylesheet" href="/css/style-simone.css">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Inserisci richiesta | Sonstuf</title>
	</head>

	<body>

		<c:import url="/prefabs/navbar.jsp"></c:import>

		<div class="container">
			<div class ="row">
				<div class="col-md-12">
					<h1>Inserisci una richiesta</h1>
					<hr>
				</div>
			</div>

			<br>

			<div class="alert alert-danger fade in hidden" id="error-alert">
				<strong>Errore!</strong>
				<span id="error-message"></span>
			</div>

			<form name="form-new-request" class="form-horizontal" role="form" action="/RequestsServlet">

				<input type="hidden" name="op" value="insert">
				<input type="hidden" name="user" value=<%= request.getParameter("idUser")%>>

				<div class="row">
					<div class="col-md-8">
						<div class="form-group">
							<label class="control-label col-md-3" for="title">Ttitolo:</label>
							<div class="col-md-9">
								<input type="text" id="title" class="form-control" name="title"
											 placeholder="Inserisci un titolo per la richiesta"/>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-3" for="category">Categoria:</label>
							<div class="col-md-9">
								<select class="form-control" id="category" name="categoryId">
									<option value="" disabled selected> Scegli una categoria</option>
									<script id="category-template" type="text/x-handlebars-template">
										<option value="{{id}}">{{category}}</option>
									</script>
								</select>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-3" for="place">Luogo:</label>
							<div class="col-md-9">
								<input type="text" id="place" class="form-control" name="place" placeholder="Dove?"/>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-3" for="time">Quando:</label>
							<div class="col-md-9">
								<input type="text" id="time" class="form-control" name="time" placeholder="Quando?"/>
							</div>
						</div>
					</div>

					<div class="col-md-4" style="text-align: center" id="img">
						<img src="http://www.placehold.it/350x180">
					</div>
				</div>



				<div class="form-group">
					<label class="control-label col-md-2" for="description">Descrizione:</label>
					<div class="col-md-10">
						<textarea class="form-control" rows="5" id="description" name="description"></textarea>
					</div>
				</div>

				<div class="form-group">
					<div class="col-md-2">
						<span class="btn btn-primary btn-file btn-block">
							Carica immagine
							<input id="picture" type="file" class="file">
						</span>
					</div>

					<div class="col-md-8"></div>

					<div class="col-md-2">
						<input type="submit" class="btn btn-success btn-block" id="btn-submit" value="Conferma">
					</div>
				</div>

			</form>
		</div>

		<c:import url="/prefabs/footer.jsp"></c:import>

	</body>
</html>
