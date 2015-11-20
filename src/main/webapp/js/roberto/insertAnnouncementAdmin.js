var user={
	name:"",
	surname:"",
	telephone:"",
	email:"",
	birthdate:""
}

$(document).ready(function(){

	$("#registra").hide();
	$("#rowTable").hide();
	eventCerca();
	eventUser();


});

function eventCerca(){

	$("#cerca").click(function(){
		user.name=$("#name").val();
		user.surname=$("#surname").val();
		user.telephone=$("#telephone").val();
		user.email=$("#email").val();
		user.birthdate=$("#birthdate").val();


		var json=jQuery.extend(true, {}, user);
		console.log(json);
		$.ajax({
			type: "POST",
			url: "/GetUsers",
			data: json,
			contentType: "application/json; charset=utf-8",
			dataType: "json",
			success: function(data){

				if(data.length==0){
					registraUtente(json);
				} else{
					updateTable(data);
				}


			},
			failure: function(errMsg) {
				alert(errMsg);
			}
		});



	});

}

function registraUtente(json){
	$("#registra").show();
	$("#registra").click(function(){
		$.ajax({
			type: "POST",
			url: "/RegisterUsers",
			data: json,
			contentType: "application/json; charset=utf-8",
			dataType: "json",
			success: function(data){
				location.href = 'inserisciRichiesta.jsp';
			},
			failure: function(errMsg) {
				alert(errMsg);
			}
		});
	});
}
function updateTable(data){

	$("#rowTable").show();

	var source = $("#request-template").html();
	var template = Handlebars.compile(source);

	for (var i = 0; i < data.length; i++){
		var context = {
			id:data[i].id,
			name:data[i].name,
			surname: data[i].surname,
			telephone: data[i].telephone,
			email: data[i].email,
			birthdate: data[i].birthdate,

		};
		var html = template(context);
		$("#bodyTable").append(html);




	}

}

function eventUser(){

	$( "#bodyTable" ).on( "click", "tr", function() {
		var idUser=$(this).attr("id");
		location.href = 'inserisciRichiesta.jsp?idUser='+idUser;
	});

}

