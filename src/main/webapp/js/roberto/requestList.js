var category=["giardinaggio1","giardinaggio2","giardinaggio3","giardinaggio4"];
var offers = [

	{
		"idRequest" : "0000",
		"user" : {
			"name" : "Amumu1",
			"rankR" : 4.2
		},
		"request": {
			"category" : "giardinaggio",
			"title" : "a",
			"place" : "Povo1",
			"time" : "11:00-16:00",
			"postTimestamp" : "omg1!"
		}
	},
	{
		"idRequest" : "0000",
		"user" : {
			"name" : "Amumu2",
			"rankR" : 4.2
		},
		"request": {
			"category" : "giardinaggio",
			"title" : "b",
			"place" : "Povo2",
			"time" : "12:00-16:00",
			"postTimestamp" : "omg2!"
		}
	},
	{
		"idRequest" : "0000",
		"user" : {
			"name" : "Amumu3",
			"rankR" : 4.2
		},
		"request": {
			"category" : "giardinaggio",
			"title" : "c",
			"place" : "Povo3",
			"time" : "13:00-16:00",
			"postTimestamp" : "omg3!"
		}
	},
	{
		"idRequest" : "0000",
		"user" : {
			"name" : "Amumu4",
			"rankR" : 4.2
		},
		"request": {
			"category" : "giardinaggio",
			"title" : "d",
			"place" : "Povo4",
			"time" : "14:00-16:00",
			"postTimestamp" : "omg4!"
		}
	},
	{
		"idRequest" : "0000",
		"user" : {
			"name" : "Amumu5",
			"rankR" : 4.2
		},
		"request": {
			"category" : "giardinaggio",
			"title" : "e",
			"place" : "Povo5",
			"time" : "15:00-16:00",
			"postTimestamp" : "omg5!"
		}
	}];

$(document).ready(function(){

	updateRequestList();
	updateCategory();

});

function updateRequestList(){

	var source = $("#request-template").html();
	var template = Handlebars.compile(source);

	$("#list").empty();

	for (var i = 0; i < offers.length; i++){
		var context = {
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

	$("#category").empty();

	for (var i = 0; i < category.length; i++){
		var context = {
			category: category[i]

		};
		var html = template(context);
		$("#category").append(html);
	}

}
