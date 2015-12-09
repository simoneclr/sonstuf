$(document).ready(function(){

	$.getJSON("/AuthenticationServlet?op=checkLogin", function(data){
	}).done(function(data){
		var success = data.success;

		if (success){
			$("#logged-user-nav").show();
		} else {
			$("#not-logged-user-nav").show();
		}
	})

});