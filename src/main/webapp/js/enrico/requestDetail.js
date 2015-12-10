//var idRequest = '${idRequest}';
function showMessageOffer(message) {
	$("#messageOffer").text(message);
	$("#error-alert").removeClass("hidden");
}


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


			$("#sendOffer").on("click", function () {
				var OK_RESPONSE = "success";
				var ERROR_RESPONSE = "fail";
				var USER_NOT_LOGGED_RESPONSE = "not_logged";
				var CONSTRAINT_VIOLATION = "constraint_violation";
				$.ajax({
					type: "GET",
					url: "/acceptrequest?idRequest=" + idRequest,
					dataType: "text",
					success: function (data) {
						var message = "unknown response";
						if (data === OK_RESPONSE)
							location.href = 'private/jobsConfirmsAccepted.jsp';
						else if (data === ERROR_RESPONSE)
							message = "error";
						else if (data === USER_NOT_LOGGED_RESPONSE)
							message = "devi loggarti per accedere a questa funzionalità";
						else if (data === CONSTRAINT_VIOLATION)
							message = "hai già dato disponibilità per questa richiesta";
						showMessageOffer(message);
					},
					error: function (errMsg) {
						showMessageOffer(errMsg);
					}
				});
			});
		});
	},
	fail: function () {
		console.log("failed to get json");
	}
});