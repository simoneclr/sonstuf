<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:import url="/prefabs/header.jsp"></c:import>
	<link href="/css/enricoStyle.css" rel="stylesheet">
	<script language="javascript">
		var idRequest = <%= request.getParameter("idRequest")%>;
	</script>
	<script src="/js/enrico/myRequestDetail.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Dettaglio richiesta</title>
</head>
<body>
<c:import url="/prefabs/navbar.jsp"></c:import>
<nav class="navbar navbar-fixed-top request">
	<div class="container">
		<div id="requestContainer" class="panel box-shadow">
			<script id="request" type="text/x-handlebars-template">
				<div class="row">
					<div class="col-xs-4">
						<img class="icon img-rounded"
						     src="{{REQUEST_IMAGE}}">
					</div>
					<div class="col-xs-4">
						<h3 class="title">{{REQUEST_TITLE}}</h3>
						<br>

						<div class="description">
							{{REQUEST_DESCRIPTION}}
						</div>
					</div>
					<div class="col-xs-4 text-center" style="padding: 10px">
						<small><cite> <i class="glyphicon glyphicon-map-marker"></i>{{PLACE}}</cite></small>
						<small><cite> <i class="glyphicon glyphicon-time"></i>{{TIME}}</cite></small>
						<small><cite> <i class="glyphicon glyphicon-user"></i><span
								class="requesterName"></span></cite></small>
					</div>
				</div>
			</script>
		</div>
	</div>
</nav>

<div class="container centered status">
	<div class="inCorso hidden">
		<script id="offer" type="text/x-handlebars-template">
			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-default box-shadow">
						<div class="panel-heading">
							<strong>Offerta</strong>
						</div>
						<div class="panel body" style="overflow: auto; margin-bottom: 0px">
							<div class="col-xs-2" style="padding: 10px;">
								<small><cite><i class="glyphicon glyphicon-user"></i><span
										class="offererName">{{OFFER_OFFERERNAME}}</span></cite></small>
							</div>
							<div class="col-xs-5">
								<div class="col-xs-3">
									<small>voto medio:</small>
								</div>
								<div class="col-xs-2">
									<small><cite>
										<input id="offererRank{{OFFER_ID}}" type="number" class="rating" min=0 max=5
										       step=1
										       data-size="xs">
									</cite></small>
								</div>
							</div>
							<div class="col-xs-3">
								<h4>posso aiutarti {{REQUESTER_NAME}}?</h4>
							</div>
							<div class="col-xs-2">
								<small><cite> <i class="glyphicon glyphicon-ok"></i>Incarica</cite>
								</small>
							</div>
						</div>
					</div>
				</div>
			</div>
		</script>
	</div>

	<div class="inAttesaDiValutazione hidden">
		<script id="waitingValuation" type="text/x-handlebars-template">
			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-default box-shadow">
						<div class="panel-heading">
							<strong>Valuta {{DELEGATE_NAME}}</strong>
						</div>
						<div class="panel body" style="overflow: auto; margin-bottom: 0px">
							<div class="col-xs-2" style="padding: 10px;">
								<small><cite><i class="glyphicon glyphicon-user"></i><span
										class="offererName">{{DELEGATE_NAME}}</span></cite></small>
							</div>
							<div class="col-xs-5">
								<div class="col-xs-3">
									<small>voto:</small>
								</div>
								<div class="col-xs-2">
									<small><cite>
										<input id="valuationRank" type="number" class="rating" min=0 max=5
										       step=1
										       data-size="xs">
									</cite></small>
								</div>
							</div>
							<div class="col-xs-3">
								<textarea id="valuationComment"
								          placeholder="lascia un tuo commento sull'operato di {{DELEGATE_NAME}}"></textarea>
							</div>
							<div class="col-xs-2">
								<small><cite> <i class="glyphicon glyphicon-ok"></i>Fatto</cite>
								</small>
							</div>
						</div>
					</div>
				</div>
			</div>
		</script>
	</div>
</div>

<div class="done hidden">
	<script id="doneValuation" type="text/x-handlebars-template">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default box-shadow">
					<div class="panel-heading">
						<strong>Hai valutato {{DELEGATE_NAME}}</strong>
					</div>
					<div class="panel body" style="overflow: auto; margin-bottom: 0px">
						<div class="col-xs-2" style="padding: 10px;">
							<small><cite><i class="glyphicon glyphicon-user"></i><span
									class="offererName">{{DELEGATE_NAME}}</span></cite></small>
						</div>
						<div class="col-xs-5">
							<div class="col-xs-3">
								<small>hai valutato:</small>
							</div>
							<div class="col-xs-3">
								<small><cite>
									<input id="doneValuationRank" type="number" class="rating" min=0 max=5
									       step=1
									       data-size="xs">
								</cite></small>
							</div>
						</div>
						<div class="col-xs-4">
							{{VALUATION_COMMENT}}
						</div>
					</div>
				</div>
			</div>
		</div>
	</script>
</div>
</div>

<br>
<br>
</div>

<c:import url="/prefabs/footer.jsp"></c:import>
</body>
</html>
