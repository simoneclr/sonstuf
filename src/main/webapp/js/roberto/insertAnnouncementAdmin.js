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
		user.name=$("#name").val();
		user.surname=$("#surname").val();
		user.phone=$("#telephone").val();
		user.email=$("#email").val();
		user.birthDate=$("#birthdate").val();
console.log("birthDate: "+user.birthDate);

		var json=jQuery.extend(true, {}, user);
		console.log(JSON.stringify(json));
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
					console.log("2");
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
			id:data[i].idUser,
			name:data[i].name,
			surname: data[i].surname,
			telephone: data[i].phone,
			email: data[i].email,
			birthdate: data[i].birthDate,

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

