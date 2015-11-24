var idRequest = '${idRequest}';
$.getJSON("/getrequest?idRequest=" + idRequest, function (json) {
	var request = json.request;
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
		$(".requesterName").empty().append(user.name);

		$("#rating-o").rating({
			'showCaption': false,
			'showClear': false,
			'readonly': true
		}).rating('update', parseInt(user.rankR));
	});
});
var user = json.user;

