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
				<div class="col-md-offset-2 col-md-2 col-sm-offset-2 col-sm-3">
					<p class="request_category">Categoria :</p>
				</div>
				<div class="col-md-1 col-sm-3">
					<img src="../img/giardinaggio.jpeg" class="img-responsive" id ="category2">
				</div>
				<div class="col-md-1  col-sm-3">
					<img src="../img/spesa.jpg" class="img-responsive" id ="category2">
				</div>
				<div class="col-md-1  col-sm-3">
					<img src="../img/elettronica.jpg" class="img-responsive" id ="category3">
				</div>
			</div>
			<div class ="row">
				<div class="col-md-2 col-md-offset-2">
					<p class="request_category2">Luogo :</p>
				</div>
				<div class="col-md-2 field_input">
					<input type="text"  class="form-control" name="place" placeholder="luogo"/>
				</div>
			</div>
			<div class ="row">
				<div class="col-md-2 col-md-offset-2">
					<p class="request_category2">Data :</p>
				</div>
				<div class="col-md-2 field_input">
					<input type="text"  class="form-control" name="date" placeholder="data"/>
				</div>
			</div>
			<div class ="row">
				<div class="col-md-2 col-md-offset-2">
					<p class="request_category2">Orario :</p>
				</div>
				<div class="col-md-2 field_input">
					<input type="text"  class="form-control" name="date" placeholder="orario"/>
				</div>
			</div>
			<div class ="row">
				<div class="col-md-2 col-md-offset-2">
					<p class="request_category2">Immagine :</p>
				</div>
				<div class="col-md-2 field_input2">
					<span class="btn btn-default btn-file">
						Carica immagine<input type="file">
					</span>
				</div>
			</div>
			<div class ="row">
				<div class="col-md-2 col-md-offset-2">
					<p class="request_category2">Descrizione :</p>
				</div>
				<div class="col-md-2 field_input">
					<input type="text"  class="form-control" name="date" placeholder="descrzione"/>
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
