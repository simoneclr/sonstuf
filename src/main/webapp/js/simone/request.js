$(document).ready(function (){

	$("div.alert").click(function(){
		$(this).addClass("hidden");
	});

	$("form[name=form-new-request]").submit(function (){
		$.post($(this).attr("action"), $(this).serialize(), function(json){
			var success = json.success;
			var description = json.description;

			if (success){
				window.location.replace("/webpages/private/confirmsInsertionJobs.jsp");
			} else {
				updateErrorAlert(description);
			}

		}, "json");

		//Impedisce al form di essere spedito;
		return false;
	});

});

function updateErrorAlert(msg){
	$("#error-message").text(msg);
	$("#error-alert").removeClass("hidden");
}