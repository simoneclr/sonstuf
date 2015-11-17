<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
	<c:import url="/prefabs/header.jsp"></c:import>
	<title>User Profile | Sonstuf</title>
</head>

<body style="padding-top: 50px">

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
