function prepareState0(requestingUser) {
	$(".userName").empty().append(requestingUser.name);
	$(".inCorso").removeClass("hidden");
}

function prepareState1(requestingUser) {
	var source = $("#waitingValuation").html();
	var template = Handlebars.compile(source);
	var context = {
		REQUESTER_NAME: requestingUser.name
	};
	var offerHtml = template(context);
	$(".inAttesaDiValutazione").empty().append(offerHtml);

	$("#valuationRank").rating({
		'showCaption': false,
		'showClear': false,
		'readonly': false
	}).rating('update', requestingUser.rankR);
	$(".inAttesaDiValutazione").removeClass("hidden");
}

function prepareState2(requestingUser, valuation) {
	var source = $("#doneValuation").html();
	var template = Handlebars.compile(source);
	var context = {
		REQUESTER_NAME: requestingUser.name,
		VALUATION_COMMENT: valuation.comment
	};
	var valuationHtml = template(context);
	$(".done").empty().append(valuationHtml);
	$("#doneValuationRank").rating({
		'showCaption': false,
		'showClear': false,
		'readonly': true
	}).rating('update', parseInt(valuation.rank));
	$(".done").removeClass("hidden");
}
function setState(state, requestingUser, valuation) {
	switch (state) {
		case 0:
			prepareState0(requestingUser);
			break;
		case 1:
			prepareState1(requestingUser);
			break;
		case 2:
			prepareState2(requestingUser, valuation);
			break;
		case 3:
			alert("sorry invalid state");
	}
}

$.getJSON("/getmyoffer?idOffer=" + idOffer, function (json) {
	var request = json.request;
	var state = parseInt(json.state);
	var requestingUser = json.requestingUser;
	var valuation = json.valuation;
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

		setState(state, requestingUser, valuation);

	});
});