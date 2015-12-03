//var idRequest = '${idRequest}';
function showMessageOffer(message) {
	$(".sendOffer").append("<p>" + message + "</p>");
}

$("#sendOffer").on("click", function () {
	console.log("OFFER MAN!");
	var OK_RESPONSE = "success";
	var ERROR_RESPONSE = "fail";
	var USER_NOT_LOGGED_RESPONSE = "not_logged";
	$.ajax({
		type: "POST",
		url: "/acceptrequest",
		dataType: "string",
		success: function (data) {
			var message;
			if (data === OK_RESPONSE)
				message = "done";
			else if (data === ERROR_RESPONSE)
				message = "error";
			else if (data === USER_NOT_LOGGED_RESPONSE)
				message = "you are not logged in";
			showMessageOffer(message);
		},
		error: function (errMsg) {
			alert(errMsg);
		}
	});
});

$.ajax({
	type: "GET",
	url: "/getrequest?idRequest=" + idRequest,
	contentType: "application/json; charset=utf-8",
	dataType: "json",
	success: function (json) {
		console.log("json: " + JSON.stringify(json));
		
		var request = json.request;

		var user = json.user;

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
			}).rating('update', parseFloat(user.rankO));

		});
	},
	fail: function () {
		console.log("failed to get json");
	}
});