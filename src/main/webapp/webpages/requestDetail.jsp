<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:import url="/prefabs/header.jsp"></c:import>
	<link href="/css/enricoStyle.css" rel="stylesheet">
	<script type="text/javascript">
		var idRequest = <%= request.getParameter("idRequest")%>;
	</script>
	<script src="/js/enrico/requestDetail.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Dettaglio richiesta</title>

</head>
<body>
<c:import url="/prefabs/navbar.jsp"></c:import>
<div class="container">
	<div id="requestContainer">
		<script id="request" type="text/x-handlebars-template">
			<div class="well well-xm box-shadow">
				<h1 class="title">
					{{REQUEST_TITLE}}
				</h1>
			</div>
			<div class="row">
				<div class="col-md-8">
					<img class="icon img-rounded" src="{{REQUEST_IMAGE}}">
				</div>
				<div class="col-ms-4 text-center">
					<div style="padding: 5%;">
						<div class="userInfo text-center">
							<small><cite> <i class="glyphicon glyphicon-map-marker"></i>{{PLACE}}</cite></small>
							<small><cite> <i class="glyphicon glyphicon-time"></i>{{TIME}}</cite></small>
							<small><cite> <i class="glyphicon glyphicon-user"></i><span
									class="requesterName"></span></cite></small>
							<small><cite>
								<input id="rating-o" type="number" class="rating" min=0 max=5 step=1 data-size="xs">
							</cite></small>

						</div>
					</div>
				</div>
			</div>
			<div class="row description text-center" style="padding-top: 10px;">
				<div class="col-sm-12">
					<h3>{{REQUEST_DESCRIPTION}}</h3>
				</div>
			</div>
		</script>
	</div>

</div>
<div class="panel panel_requestDetail">
	<div class="panel-heading panel_heading_requestDetail">
		<strong>Offriti</strong>
	</div>
	<div class="panel-body">
		<div class="well well-xm box-shadow body_box">
			<div class="col-md-3 col-md-offset-3 col-sm-offset-3 col-sm-4 col-xs-5 col-xs-offset-1">
				<h3>Desideri aiutare <span class="requesterName"></span>?</h3>
			</div>
			<div class="col-md-2 col-md-offset-2 col-sm-offset-1 col-sm-4 col-xs-offset-1 col-xs-5 ">
				<button id="sendOffer"
				        class="row btn btn-primary">
					<small><cite><i class="glyphicon glyphicon-ok"></i>Accetta</cite></small>
				</button>
				<div id="messageOffer" class="row">

				</div>
			</div>
		</div>
	</div>
</div>


<c:import url="/prefabs/footer.jsp"></c:import>
</body>
</html>
