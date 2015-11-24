/**
 * Created by gianluke on 19/11/15.
 */
$(document).ready(function () {

	function checkPassword(){
		var passWord1 = $("#password1").val();
		var passWord2 = $("#password2").val();
		console.log(passWord1+ "    "+passWord2);
		if (passWord1 != passWord2) {
			$("#password1").parent('div').addClass("has-error has-feedback");





		} else{
			document.getElementById("modulo").submit();
		}

	}

	$("#button_submit_register").on("click",function(){
		checkPassword();
	});
});