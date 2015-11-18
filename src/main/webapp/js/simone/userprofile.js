//Static, temporary data
var loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit,sed do eiusmod tempor incididunt" +
		"ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation" +
		"ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in " +
		"reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur." +
		"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia" +
		"deserunt mollit anim id est laborum.";

var user = {
	idUser : "007",
	name : "Roberto \'Amumu\'",
	surname : "Fellin",
	telephone : "Non te lo dico gné gné!",
	email : "rf.garenlol@dambel.zum",
	birthdate : "21/12/2012",
	rankO : 3.5,
	rankR: 4.2
};

var requests = [
	{
		"idRequest" : "0000",
		"user" : {
			"name" : "Amumu",
			"rankR" : 4.2
		},
		"request": {
			"category" : "Giardinaggio",
			"categoryDescription" : loremIpsum,
			"place" : "Dambel",
			"time" : "quando cazzo volete",
			"postTimestamp" : "wtf?"
		}
	},
	{
		"idRequest" : "0000",
		"user" : {
			"name" : "Amumu",
			"rankR" : 4.2
		},
		"request": {
			"category" : "Giardinaggio",
			"categoryDescription" : loremIpsum,
			"place" : "Dambel",
			"time" : "13:00-15:33",
			"postTimestamp" : "wtf?"
		}
	},
	{
		"idRequest" : "0000",
		"user" : {
			"name" : "Amumu",
			"rankR" : 4.2
		},
		"request": {
			"category" : "Giardinaggio",
			"categoryDescription" : loremIpsum,
			"place" : "Dambel",
			"time" : "13:00-15:33",
			"postTimestamp" : "wtf?"
		}
	},
	{
		"idRequest" : "0000",
		"user" : {
			"name" : "Amumu",
			"rankR" : 4.2
		},
		"request": {
			"category" : "Giardinaggio",
			"categoryDescription" : loremIpsum,
			"place" : "Dambel",
			"time" : "13:00-15:33",
			"postTimestamp" : "wtf?"
		}
	},
	{
		"idRequest" : "0000",
		"user" : {
			"name" : "Amumu",
			"rankR" : 4.2
		},
		"request": {
			"category" : "Giardinaggio",
			"categoryDescription" : loremIpsum,
			"place" : "Dambel",
			"time" : "13:00-15:33",
			"postTimestamp" : "wtf?"
		}
	}];

var offers = [
	{
		"idOffer": "<1111>",
		"isInCharge" : "true",
		"user" : {
			"name" : "Darius",
			"rankR" : 4.8
		},
		"request" : {
			"category" : "DIY",
			"categoryDescription" : loremIpsum,
			"place" : "Povo",
			"time" : "11:00-16:00",
			"postTimestamp" : "omg!"}
	},
	{
		"idOffer": "<1111>",
		"isInCharge" : "true",
		"user" : {
			"name" : "Darius",
			"rankR" : 4.8
		},
		"request" : {
			"category" : "DIY",
			"categoryDescription" : loremIpsum,
			"place" : "Povo",
			"time" : "11:00-16:00",
			"postTimestamp" : "omg!"}
	},
	{
		"idOffer": "<1111>",
		"isInCharge" : "true",
		"user" : {
			"name" : "Darius",
			"rankR" : 4.8
		},
		"request" : {
			"category" : "DIY",
			"categoryDescription" : loremIpsum,
			"place" : "Povo",
			"time" : "11:00-16:00",
			"postTimestamp" : "omg!"}
	},
	{
		"idOffer": "<1111>",
		"isInCharge" : "true",
		"user" : {
			"name" : "Darius",
			"rankR" : 4.8
		},
		"request" : {
			"category" : "DIY",
			"categoryDescription" : loremIpsum,
			"place" : "Povo",
			"time" : "11:00-16:00",
			"postTimestamp" : "omg!"}
	},
	{
		"idOffer": "<1111>",
		"isInCharge" : "true",
		"user" : {
			"name" : "Darius",
			"rankR" : 4.8
		},
		"request" : {
			"category" : "DIY",
			"categoryDescription" : loremIpsum,
			"place" : "Povo",
			"time" : "11:00-16:00",
			"postTimestamp" : "omg!"}
	}];

$(document).ready(function(){

	updatePersonalData();

	updateUserRatings();

	updateRequests();

	updateOffers();

});

function updatePersonalData(){
	var completeName = user.name + " " + user.surname;
	document.title = completeName + "| Sonstuf";
	$("#ucname").text(completeName);
	$("#telnum").text(user.telephone);
	$("#bdate").text(user.birthdate);
	$("#email").text(user.email);
}

function updateUserRatings(){
	$("#rating-o").rating('update', user.rankO)
	$("#rating-r").rating('update', user.rankR);
}

function updateRequests(){
	var source = $("#request-template").html();
	var template = Handlebars.compile(source);

	$("#requests").empty();

	for (var i = 0; i < requests.length; i++){
		var context = {
			title: requests[i].request.category,
			description: requests[i].request.categoryDescription,
			place: requests[i].request.place,
			time: requests[i].request.time
		};
		var html = template(context);
		$("#requests").append(html);
	}
}

function updateOffers(){
	var source = $("#offers-template").html();
	var template = Handlebars.compile(source);

	$("#offers").empty();

	for (var i = 0; i < offers.length; i++){
		var context = {
			title: offers[i].request.category,
			description: offers[i].request.categoryDescription,
			place: offers[i].request.place,
			time: offers[i].request.time
		};
		var html = template(context);
		$("#offers").append(html);
	}
}