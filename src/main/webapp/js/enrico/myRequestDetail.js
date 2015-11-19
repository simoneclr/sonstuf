function addOffert(id) {
	var source = $("#offer").html();
	var template = Handlebars.compile(source);
	var context = {
		OFFER_OFFERERNAME: "I'mOfferer",
		OFFER_ID: id,
		REQUESTER_NAME: "I'mRequester"
	};
	var offerHtml = template(context);
	$(".inCorso").append(offerHtml);


	$("#offererRank" + id).rating({
		'showCaption': false,
		'showClear': false,
		'readonly': true
	}).rating('update', 5);

}
function prepareState0() {
	addOffert(1);
	addOffert(2);
	$(".inCorso").removeClass("hidden");
}

function prepareState1() {
	var source = $("#waitingValuation").html();
	var template = Handlebars.compile(source);
	var context = {
		DELEGATE_NAME: "I'mDelegate"
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
		DELEGATE_NAME: "I'mDelegate",
		VALUATION_COMMENT: "è stato molto preciso e gentile. Ha lavorato bene"
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
		REQUEST_DESCRIPTION: "Qualcuno potrebbe aiutarmi a togliere le erbacce?",
		PLACE: "Dambel",
		TIME: "22/12/1994"
	};
	var requestHtml = template(context);
	$("#requestContainer").empty().append(requestHtml);
	$(".requesterName").empty().append("I'mRequester");
	setState(2);
});

