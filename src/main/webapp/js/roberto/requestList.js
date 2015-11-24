//var offers;
/*var offers = [

 {
 "idRequest" : "0001",
 "user" : {
 "name" : "Amumu1",
 "rankR" : 4.2
 },
 "request": {
 "category" : "giardinaggio",
 "title" : "a",
 "place" : "Povo1aA",
 "time" : "11:00-16:00",
 "postTimestamp" : "omg1!"
 }
 },
 {
 "idRequest" : "0002",
 "user" : {
 "name" : "Amumu1",
 "rankR" : 4.2
 },
 "request": {
 "category" : "giardinaggio",
 "title" : "b",
 "place" : "Povo2bB",
 "time" : "12:00-16:00",
 "postTimestamp" : "omg2!"
 }
 },
 {
 "idRequest" : "0003",
 "user" : {
 "name" : "Amumu3",
 "rankR" : 4.2
 },
 "request": {
 "category" : "giardinaggio",
 "title" : "c",
 "place" : "Povo3cC",
 "time" : "13:00-16:00",
 "postTimestamp" : "omg3!"
 }
 },
 {
 "idRequest" : "0004",
 "user" : {
 "name" : "Amumu4",
 "rankR" : 4.2
 },
 "request": {
 "category" : "giardinaggio",
 "title" : "d",
 "place" : "Povo4dD",
 "time" : "14:00-16:00",
 "postTimestamp" : "omg4!"
 }
 },
 {
 "idRequest" : "0005",
 "user" : {
 "name" : "Amumu5",
 "rankR" : 4.2
 },
 "request": {
 "category" : "giardinaggio",
 "title" : "e",
 "place" : "Povo5eE",
 "time" : "15:00-16:00",
 "postTimestamp" : "omg5!"
 }
 }];
 */
$(document).ready(function(){

	setOffers();

	updateCategory();
	eventList();


});


function setOffers(){
	$.getJSON("/RequestsServlet?op=listAll", function(json){

				updateRequestList(json);
				eventFilter(json);
	})
			.done(function() {
				console.log( "second success" );
			})
			.fail(function() {
				console.log( "error" );
			})
			.always(function() {
				console.log( "complete" );
			});


}
function updateRequestList(offers){

	var source = $("#request-template").html();
	var template = Handlebars.compile(source);

	$("#list").empty();

	for (var i = 0; i < offers.length; i++){
		var context = {
			id:offers[i].idRequest,
			category: offers[i].request.category,
			title: offers[i].request.title,
			place: offers[i].request.place,
			time: offers[i].request.time,
			postTimestamp: offers[i].request.postTimestamp,
			name:offers[i].user.name
		};
		var html = template(context);
		$("#list").append(html);
	}

}


function updateCategory(){

	var source = $("#category-template").html();
	var template = Handlebars.compile(source);

	var context;
	console.log("1");
	$.getJSON("/CategoriesServlet", function(json){

				for (var i = 0; i < json.length; i++) {
					context = {
						category: json[i].category

					};
					var html = template(context);
					$("#category").append(html);
				}

			})
			.done(function() {
				console.log( "second success" );
			})
			.fail(function() {
				console.log( "error" );
			})
			.always(function() {
				console.log( "complete" );
			});

}

function eventList(){

	$( "#list" ).on( "click", "div", function() {
		var idRequest=$(this).attr("id");
		location.href = 'requestDetail.jsp?idRequest='+idRequest;
	});

}

function eventFilter(offers){

	$("#btn").click(function(){
		var category=$("#category").val();
		var name=$("#name").val();
		var place=$("#place").val();
		$("#list").empty();

		var source = $("#request-template").html();
		var template = Handlebars.compile(source);

		for (var i = 0; i < offers.length; i++){
			if(offers[i].request.category.toLowerCase().indexOf(category.toLowerCase())>-1 && offers[i].request.place.toLowerCase().indexOf(place.toLowerCase())>-1 && offers[i].user.name.toLowerCase().indexOf(name.toLowerCase())>-1){

				var context = {
					id:offers[i].idRequest,
					category: offers[i].request.category,
					title: offers[i].request.title,
					place: offers[i].request.place,
					time: offers[i].request.time,
					postTimestamp: offers[i].request.postTimestamp,
					name:offers[i].user.name
				};
				var html = template(context);
				$("#list").append(html);



			};
		}

	});

}