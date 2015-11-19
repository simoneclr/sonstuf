function prepareState0() {
	$(".userName").empty().append("userName");
	$(".inCorso").removeClass("hidden");
}

function prepareState1() {
	var source = $("#waitingValuation").html();
	var template = Handlebars.compile(source);
	var context = {
		REQUESTER_NAME: "I'mRequester"
	};
	var offerHtml = template(context);
	$(".inAttesaDiValutazione").empty().append(offerHtml);

	$("#valuationRank").rating({
		'showCaption': false,
		'showClear': false,
		'readonly': false
	}).rating('update', 5);
	$(".inAttesaDiValutazione").removeClass("hidden");
}

function prepareState2() {
	var source = $("#doneValuation").html();
	var template = Handlebars.compile(source);
	var context = {
		REQUESTER_NAME: "I'mRequester",
		VALUATION_COMMENT: "è stato molto preciso e gentile. Non ha preteso l'impossibile"
	};
	var valuationHtml = template(context);
	$(".done").empty().append(valuationHtml);
	$("#doneValuationRank").rating({
		'showCaption': false,
		'showClear': false,
		'readonly': true
	}).rating('update', 5);
	$(".done").removeClass("hidden");
}
function setState(state) {
	switch (state) {
		case 0:
			prepareState0();
			break;
		case 1:
			prepareState1();
			break;
		case 2:
			prepareState2();
			break;
		case 3:
			alert("sorry invalid state");
	}
}

$(document).ready(function () {
	var source = $("#request").html();
	var template = Handlebars.compile(source);
	var context = {
		REQUEST_IMAGE: "http://media.lavorincasa.it/blog/giardinaggio/2013/03/lasagna3.jpg",
		REQUEST_TITLE: "Orto",
		REQUEST_DESCRIPTION: "Cerco una persona che possa aiutarmi a togliere le erbacce dall'orto",
		PLACE: "Dambel",
		TIME: "22/12/1994"
	};
	var requestHtml = template(context);
	$("#requestContainer").empty().append(requestHtml);

	setState(2);

});