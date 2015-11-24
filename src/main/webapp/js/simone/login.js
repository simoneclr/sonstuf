$(document).ready(function (){

	$("form[name=form-login]").submit(function (){
		$.post($(this).attr("action"), $(this).serialize(), function(json){
			console.log(json.success);
			console.log(json.description);
		}, "json");

		//Impedisce al form di essere spedito;
		return false;
	});

});