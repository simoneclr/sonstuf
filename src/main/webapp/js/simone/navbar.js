$(document).ready(function () {

	$.getJSON("/AuthenticationServlet?op=checkLogin", function (data) {
	}).done(function (data) {
		var success = data.success;

		if (success) {
			$("#logged-user-nav").show();
		} else {
			$("#not-logged-user-nav").show();
		}
	});

	$("#logout").on("click", function () {
		$.getJSON("/AuthenticationServlet?op=logout", function (data) {
		}).done(function (data) {
			var success = data.success;
			if (success){
				window.location.replace("/webpages/home.jsp");
			} else {
				alert("logout failed");
			}
		});
	});

});