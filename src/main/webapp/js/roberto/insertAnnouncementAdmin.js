var user={
	name:"",
	surname:"",
	phone:"",
	email:"",
	birthDate:""
}

$(document).ready(function(){

	$("#registra").hide();
	$("#rowTable").hide();
	eventCerca();
	eventUser();


});

function eventCerca(){

	$("#cerca").click(function(){
		$("#error-alert").addClass("hidden");
		user.name=$("#name").val();
		user.surname=$("#surname").val();
		user.phone=$("#telephone").val();
		user.email=$("#email").val();
		user.birthDate=$("#birthdate").val();

		var json=jQuery.extend(true, {}, user);
		$.ajax({
			type: "POST",
			url: "/GetUsers",
			data: JSON.stringify(json),
			contentType: "application/json; charset=utf-8",
			dataType: "json",
			success: function(input){
				var data= JSON.parse(JSON.stringify(input));
				if(data.length==0){
					registraUtente(json);
				} else{
					registraUtente(json);
					updateTable(data);
				}


			},
			error: function(errMsg) {
				console.log("failed: " + errMsg);
			}
		});



	});

}

function registraUtente(json){
	$("#registra").show();
	$("#rowTable").hide();

	$("#registra").click(function(){

console.log(json);
		var u="name="+json.name+"&surname="+json.surname+"&phone="+json.phone+"&email="+json.email+"&birthdate="+json.birthDate+"&op=register";

		console.log(u);
		$("#registra").hide();
		$.ajax({
			type: "POST",
			url: "/webpages/private/admin/AdminRegistrationServlet",
			data: u,
			contentType: "application/x-www-form-urlencoded",
			dataType: "json",
			success: function(input){
				var data= input;//JSON.parse(JSON.stringify(input));
console.log("data: "+data);

				console.log("s: "+data.success);
				console.log("s: "+data.description);
				if(data.success){

location.href = '../inserisciRichiesta.jsp?idUser='+data.description;
				}
				else{
					updateErrorAlert(data.description);
				}

			},
			error: function(errMsg) {
				alert(errMsg);
			}
		});
	});
}

function updateErrorAlert(msg){
	$("#error-message").text(msg);
	$("#error-alert").removeClass("hidden");
}

function updateTable(data){
	$("#registra").show();
	$("#rowTable").show();
	var table_html="";
	$("#table-template").empty();
	var table_html= "<div class=\"table-responsive\">"+
			"<table id=\"myTable\" class=\"display table\" width=\"100%\">"+
			"<thead>"+
			"<tr>"+
			"<th>Nome</th>"+
			"<th>Cognome</th>"+
			"<th>Telefono</th>"+
			"<th>Email</th>"+
			"<th>Data di nascita</th>"+
			"</tr>"+
			"</thead>"+
			"<tbody id=\"bodyTable\">";


	var source = $("#template-user").html();
	var template = Handlebars.compile(source);
	for (var i = 0; i < data.length; i++){
		var context = {
			id:data[i].idUser,
			name:data[i].name,
			surname: data[i].surname,
			telephone: data[i].telephone,
			email: data[i].email,
			birthdate: data[i].birthdate,

		};
		var html = template(context);
		table_html+=html;

	}
	table_html+="</tbody> </table>";
	$("#table-template").append(table_html);
	$('#myTable').dataTable();


	eventUser();
}

function eventUser(){

	$( "#bodyTable" ).on( "click", "tr", function() {
		var idUser=$(this).attr("id");
		location.href = '../inserisciRichiesta.jsp?idUser='+idUser;
	});





}

