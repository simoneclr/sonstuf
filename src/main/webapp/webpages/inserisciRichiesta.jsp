<%--
  Created by IntelliJ IDEA.
  User: roberto
  Date: 14/11/15
  Time: 11.37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<c:import url="/prefabs/header.jsp"></c:import>
		<link href="../css/style-gianluca.css" rel="stylesheet">
		<script src="../js/gianluca/inserisci-richiesta.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Inserisci richiesta</title>
	</head>
	<body>
	<c:import url="/prefabs/navbar.jsp"></c:import>

	<div class="container">
		<div class ="row">
			<div class="col-md-offset-1 col-md-10">
				<p class="request_title">Inserisci una richiesta</p>
				<hr>
			</div>

		</div>
		<br>
		<form class="form-horizontal">
			<div class ="row">
				<div class="col-md-2 col-md-offset-2">
					<p class="request_category">Titolo :</p>
				</div>
				<div class="col-md-6 col-sm-10 col-xs-10 field_input_title">
					<input type="text"  class="form-control" name="title" placeholder="titolo"/>
				</div>
			</div>
			<div class ="row">
				<div class="col-md-offset-2 col-md-2 col-sm-3">
					<p class="request_category">Categoria :</p>
				</div>
				<div class="col-md-2 col-sm-2 col-xs-4">
					<img src="../img/giardinaggio.jpeg" class="img-responsive img_category deselected" id ="category1">
					<p id="category_p1">Giardinaggio</p>
				</div>
				<div class="col-md-2 col-sm-2 col-xs-4">
					<img src="../img/spesa.jpg" class="img-responsive img_category deselected" id ="category2">
					<p id="category_p2">Spesa</p>
				</div>
				<div class="col-md-2 col-sm-2 col-xs-4">
					<img src="../img/elettronica.jpg" class="img-responsive img_category deselected" id ="category3">
					<p id="category_p3">Elettronica</p>
				</div>
			</div>
			<div class ="row">
				<div class="col-md-2 col-md-offset-2 col-sm-2">
					<p class="request_category2">Luogo :</p>
				</div>
				<div class="col-md-2 col-sm-2 col-xs-4 field_input">
					<input type="text"  class="form-control" name="place" placeholder="luogo"/>
				</div>
			</div>
			<div class ="row">
				<div class="col-md-2 col-md-offset-2 col-sm-2">
					<p class="request_category2">Data :</p>
				</div>
				<div class="col-md-2 col-sm-2 col-xs-10 field_input">
					<input type="text"  class="form-control" name="time" placeholder="data"/>
				</div>
			</div>
			<div class ="row">
				<div class="col-md-2 col-sm-3 col-md-offset-2">
					<p class="request_category2">Immagine :</p>
				</div>
				<div class="col-md-2 col-sm-2 col-xs-4 field_input2">
					<span class="btn btn-default btn-file">
						Carica immagine<input type="file">
					</span>
				</div>
			</div>
			<div class ="row">
				<div class="col-md-2 col-sm-3 col-md-offset-2">
					<p class="request_category2">Descrizione :</p>
				</div>
				<div class="col-md-4 col-sm-4 col-xs-10  field_input">
					<textarea class="form-control" name="description" rows="5" id="comment"></textarea>
				</div>
			</div>
			<div class ="row">
				<div class="col-md-2 col-md-offset-9 col-sm-2 col-sm-offset-9 col-xs-3  field_input">
					<input type="submit" name="enter" class="btn btn-success" id="request_insert" value="Inserisci">
				</div>
			</div>


		</form>
	</div>
	<br>
	<br>
	<br>
	<br>
	<c:import url="/prefabs/footer.jsp"></c:import>
	</body>
</html>
