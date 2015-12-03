/**
 * Created by gianluke on 19/11/15.
 */
$(document).ready(function () {
	start();
	$("#email").blur(validate_Email);
	$("#password1").keyup(validate1);
	$("#password2").keyup(validate2);
});



function start(){
	$("#password2").prop("disabled",true);
}

function addErrorSuccessBlockMessage(msg,classe){
	$(".msg").empty();
	$(".msg").removeClass("alert alert-danger");
	$(".msg").removeClass("alert alert-success");
	$(".msg").addClass(classe);
	$(".msg").append("<p>"+msg+"</p>");
}

function addESClass(elementP,classe){
	$("#"+elementP).parent('div').addClass(classe);
}

function removeESClass(elementP,classe){
	$("#"+elementP).parent('div').removeClass(classe);
}

function validateEmail_Support(email) {
	var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
	if(email=="") return false;
	return emailReg.test(email);
}

function validate_Email(){
	if (!validateEmail_Support($("#email").val())){
		var msg = "Inserire una mail valida";
		addErrorSuccessBlockMessage(msg,"alert alert-danger");
		addESClass("email","has-error has-feedback");
	}
	else{
		removeESClass("email","has-error has-feedback");
		addESClass("email","has-success has-feedback");
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
			removeESClass("password1","has-error has-feedback");
			removeESClass("password2","has-error has-feedback");
		}
	}
	else{
		removeESClass("password1","has-success has-feedback");
		removeESClass("password2","has-success has-feedback");
		removeESClass("password1","has-error has-feedback");
		removeESClass("password2","has-error has-feedback");
		$("#password2").prop("disabled",true);
	}
}

function validate2(){
	var password1 = $("#password1").val();
	var password2 = $("#password2").val();

	if (password1 != password2){
		removeESClass("password1","has-success has-feedback");
		removeESClass("password2","has-success has-feedback");
		addESClass("password1","has-error has-feedback");
		addESClass("password2","has-error has-feedback");
		msg = "Le passwords non coincidono";
		addErrorSuccessBlockMessage(msg,"alert alert-danger");
	}
	else{
		removeESClass("password1","has-error has-feedback");
		removeESClass("password2","has-error has-feedback");
		addESClass("password1","has-success has-feedback");
		addESClass("password2","has-success has-feedback");
		msg = "Le passwords coincidono";
		addErrorSuccessBlockMessage(msg,"alert alert-success");
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
	var send = true;
	if(!checkName()){
		addESClass("name","has-error has-feedback");
		send = false;
	}
	else{
		removeESClass("name","has-error has-feedback");
	}
	if(!checkSurname()){
		addESClass("surname","has-error has-feedback");
		send = false;
	}
	else{
		removeESClass("surname","has-error has-feedback");
	}
	if(!checkBirthdate()){
		addESClass("birthdate","has-error has-feedback");
		send = false;
	}
	else{
		removeESClass("birthdate","has-error has-feedback");
	}
	if(!checkEmail()){
		addESClass("email","has-error has-feedback");
		send = false;
	}
	else{
		removeESClass("email","has-error has-feedback");
	}
	if(!checkPhone()){
		addESClass("phone","has-error has-feedback");
		send = false;
	}
	else{
		removeESClass("phone","has-error has-feedback");
	}
	if(!checkPassword()){
		addESClass("password1","has-error has-feedback");
		addESClass("password2","has-error has-feedback");
		send = false;
	}
	else{
		removeESClass("password1","has-error has-feedback");
		removeESClass("password2","has-error has-feedback");
	}
	return send;
}

$("#button_submit_register").click(function(event){

	if (!checkFields()){
		msg = "È stato riscontrato un errore nei seguenti campi";
		addErrorSuccessBlockMessage(msg,"alert alert-danger");
		event.preventDefault();
	}
	else{
		$("#myForm").submit();
	}
});


