function addOffert(id, offert, requesterName) {
	var source = $("#offer").html();
	var template = Handlebars.compile(source);
	var context = {
		OFFER_OFFERERNAME: offert.name,
		OFFER_ID: id,
		REQUESTER_NAME: requesterName
	};
	var offerHtml = template(context);
	$(".inCorso").append(offerHtml);


	$("#offererRank" + id).rating({
		'showCaption': false,
		'showClear': false,
		'readonly': true
	}).rating('update', parseInt(offert.rankO));
}

function prepareState0(offerers, requesterName) {
	for (var i = 0; i < offerers.length; i++) {
		addOffert(i, offerers[i], requesterName);
	}
	$(".inCorso").removeClass("hidden");
}

function prepareState1(offerer) {
	var source = $("#waitingValuation").html();
	var template = Handlebars.compile(source);
	var context = {
		DELEGATE_NAME: offerer.name
	};
	var offerHtml = template(context);
	$(".inAttesaDiValutazione").empty().append(offerHtml);
	$("#valuationRank").rating({
		'showCaption': false,
		'showClear': false,
		'readonly': false
	}).rating('update', parseInt(offerer.rankO));
	$(".inAttesaDiValutazione").removeClass("hidden");
}

function prepareState2(offerer, valuation) {
	var source = $("#doneValuation").html();
	var template = Handlebars.compile(source);
	var context = {
		DELEGATE_NAME: offerer.name,
		VALUATION_COMMENT: valuation.comment
	};
	var valuationHtml = template(context);
	$(".done").empty().append(valuationHtml);
	$("#doneValuationRank").rating({
		'showCaption': false,
		'showClear': false,
		'readonly': true
	}).rating('update', parseInt(valuation.rankO));
	$(".done").removeClass("hidden");
}
function setState(state, offerers, valuation, requesterName) {
	switch (state) {
		case 0:
			prepareState0(offerers, requesterName);
			break;
		case 1:
				if(offerers.length != 1)
				alert("numero incaricati diverso da 1, attenzione");
			prepareState1(offerers[0]);
			break;
		case 2:
			if(offerers.length != 1)
				alert("numero incaricati diverso da 1, attenzione");
			prepareState2(offerers[0], valuation);
			break;
		case 3:
			alert("sorry invalid state");
	}
}

$.getJSON("/getmyrequest?idRequest=" + idRequest, function (json) {
	var request = json.request;
	var state = parseInt(json.state);
	var valuation = json.valuation;
	var offerers = json.offerers;
	$(document).ready(function () {
		var source = $("#request").html();
		var template = Handlebars.compile(source);
		var context = {
			REQUEST_IMAGE: request.photo,
			REQUEST_TITLE: request.title,
			REQUEST_DESCRIPTION: request.description,
			PLACE: request.place,
			TIME: request.time
		};
		var requestHtml = template(context);
		$("#requestContainer").empty().append(requestHtml);
		$(".requesterName").empty().append(request.requesterName);
		setState(state, offerers, valuation, request.requesterName);
	});
});
