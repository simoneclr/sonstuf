/**
 * Created by gianluke on 19/11/15.
 */
$(document).ready(function () {
	start();
	$("#email").blur(validate_Email);
	$("#password1").keyup(validate1);
	$("#password2").keyup(validate2);
});


function addErrorBlock(msg){
	$(".msg").empty();
	$(".msg").addClass("alert alert-danger bs-alert-old-docs");
	$(".msg").append("<p>"+msg+"</p>");
}

function start(){
	$("#password2").prop("disabled",true);
}


function validateEmail_Support(email) {
	var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
	if(email=="") return false;
	return emailReg.test(email);
}

function validate_Email(){
	if (!validateEmail_Support($("#email").val())){
		$(".msg").empty();
		$(".msg").addClass("alert alert-danger bs-alert-old-docs");
		$(".msg").append("<p>È stato riscontrato un errore nei seguenti campi</p>");
		$("#email").parent('div').addClass("has-error has-feedback");
	}
	else{
		$("#email").parent('div').removeClass("has-error has-feedback");
		$("#email").parent('div').addClass("has-success has-feedback");
	}

}

function validate1(){
	var password1 = $("#password1").val();
	var password2 = $("#password2").val();


	if ((password1 != "")) {
		$("#password2").val("");
		$("#password2").prop("disabled",false);
		if (password1 == password2) {
			//$("#password2").prop("disabled",true);
			$("#password1").parent('div').removeClass("has-error has-feedback");
			$("#password2").parent('div').removeClass("has-error has-feedback");
		}
	}
	else{
		$("#password1").parent('div').removeClass("has-success has-feedback");
		$("#password2").parent('div').removeClass("has-success has-feedback");
		$("#password1").parent('div').removeClass("has-error has-feedback");
		$("#password2").parent('div').removeClass("has-error has-feedback");
		$("#password2").prop("disabled",true);
	}
}

function validate2(){
	var password1 = $("#password1").val();
	var password2 = $("#password2").val();

	if (password1 != password2){
		$("#password1").parent('div').removeClass("has-success has-feedback");
		$("#password2").parent('div').removeClass("has-success has-feedback");
		$("#password1").parent('div').addClass("has-error has-feedback");
		$("#password2").parent('div').addClass("has-error has-feedback");
	}
	else{
		$("#password1").parent('div').removeClass("has-error has-feedback");
		$("#password2").parent('div').removeClass("has-error has-feedback");
		$("#password1").parent('div').addClass("has-success has-feedback");
		$("#password2").parent('div').addClass("has-success has-feedback");


	}
}

function checkName(){
	if ($("#name").val()==""){
		return false;
	}
	return true;
}

function checkSurname(){
	if ($("#surname").val()==""){
		return false;
	}
	return true;
}

function checkBirthdate(){
	if ($("#birthdate").val()==""){
		return false;
	}
	return true;
}

function checkEmail(){
	if (($("#email").val()=="")||(!validateEmail_Support($("#email").val()))){
		return false;
	}
	return true;
}

function checkPhone(){
	if ($("#phone").val()==""){
		return false;
	}
	return true;
}

function checkPassword(){
	if (($("#password1").val()=="")||($("#password2").val()=="")){
		return false;
	}
	return true;
}
function checkFields(){
	if(!checkName()){
		$("#name").parent('div').addClass("has-error has-feedback");
	}
	else{
		$("#name").parent('div').removeClass("has-error has-feedback");
	}
	if(!checkSurname()){
		$("#surname").parent('div').addClass("has-error has-feedback");
	}
	else{
		$("#surname").parent('div').removeClass("has-error has-feedback");
	}
	if(!checkBirthdate()){
		$("#birthdate").parent('div').addClass("has-error has-feedback");
	}
	else{
		$("#birthdate").parent('div').removeClass("has-error has-feedback");
	}
	if(!checkEmail()){
		$("#email").parent('div').addClass("has-error has-feedback");

	}
	else{

		$("#email").parent('div').removeClass("has-error has-feedback");
	}
	if(!checkPhone()){
		$("#phone").parent('div').addClass("has-error has-feedback");
	}
	else{
		$("#phone").parent('div').removeClass("has-error has-feedback");
	}
	if(!checkPassword()){
		$("#password1").parent('div').addClass("has-error has-feedback");
		$("#password2").parent('div').addClass("has-error has-feedback");
	}
	else{
		$("#password1").parent('div').removeClass("has-error has-feedback");
		$("#password2").parent('div').removeClass("has-error has-feedback");
	}
}

$("#button_submit_register").click(function(){

	if (!checkFields()){
		msg = "È stato riscontrato un errore nei seguenti campi";
		addErrorBlockMessage(msg);
		return false;
	}
	else{
		$("#myForm").submit();
	}
});


