var idRequest = '${idRequest}';
function showMessageOffer(message){
	$(".sendOffer").append("<p>"+message+"</p>");
}

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

$(".sendOffer").click(function () {
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
})
;

