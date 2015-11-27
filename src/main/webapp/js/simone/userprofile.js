/* Static, temporary data
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
			"title" : "Raccogliete 'ste cazzo di foglie",
			"description" : loremIpsum,
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
			"title" : "Raccogliete 'ste cazzo di foglie",
			"description" : loremIpsum,
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
			"title" : "Raccogliete 'ste cazzo di foglie",
			"description" : loremIpsum,
			"place" : "Dambel",
			"time" : "12:40 - 16:50",
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
			"title" : "Raccogliete 'ste cazzo di foglie",
			"description" : loremIpsum,
			"place" : "Dambel",
			"time" : "12:40 - 16:50",
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
			"title" : "Raccogliete 'ste cazzo di foglie",
			"description" : loremIpsum,
			"place" : "Dambel",
			"time" : "12:40 - 16:50",
			"postTimestamp" : "wtf?"
		}
	}];

var offers = [
	{
		"idOffer": "<1111>",
		"isInCharge" : true,
		"user" : {
			"name" : "Darius",
			"rankR" : 4.8
		},
		"request" : {
			"category" : "DIY",
			"categoryDescription" : loremIpsum,
			"title" : "Aggiustatemi il mobile",
			"description" : loremIpsum,
			"place" : "Povo",
			"time" : "11:00-16:00",
			"postTimestamp" : "omg!"}
	},
	{
		"idOffer": "<1111>",
		"isInCharge" : false,
		"user" : {
			"name" : "Darius",
			"rankR" : 4.8
		},
		"request" : {
			"category" : "DIY",
			"categoryDescription" : loremIpsum,
			"title" : "Aggiustatemi il mobile",
			"description" : loremIpsum,
			"place" : "Povo",
			"time" : "11:00-16:00",
			"postTimestamp" : "omg!"}
	},
	{
		"idOffer": "<1111>",
		"isInCharge" : false,
		"user" : {
			"name" : "Darius",
			"rankR" : 4.8
		},
		"request" : {
			"category" : "DIY",
			"categoryDescription" : loremIpsum,
			"title" : "Aggiustatemi il mobile",
			"description" : loremIpsum,
			"place" : "Povo",
			"time" : "11:00-16:00",
			"postTimestamp" : "omg!"}
	},
	{
		"idOffer": "<1111>",
		"isInCharge" : true,
		"user" : {
			"name" : "Darius",
			"rankR" : 4.8
		},
		"request" : {
			"category" : "DIY",
			"categoryDescription" : loremIpsum,
			"title" : "Aggiustatemi il mobile",
			"description" : loremIpsum,
			"place" : "Povo",
			"time" : "11:00-16:00",
			"postTimestamp" : "omg!"}
	},
	{
		"idOffer": "<1111>",
		"isInCharge" : false,
		"user" : {
			"name" : "Darius",
			"rankR" : 4.8
		},
		"request" : {
			"category" : "DIY",
			"categoryDescription" : loremIpsum,
			"title" : "Aggiustatemi il mobile",
			"description" : loremIpsum,
			"place" : "Povo",
			"time" : "11:00-16:00",
			"postTimestamp" : "omg!"}
	}];
*/

$(document).ready(function(){
	octopus.init();
});

//MODEL
var model = {
	user: undefined,
	requests: undefined,
	offers: undefined
};

//OCTOPUS
var octopus = {
	init: function(){
		view.init();

		this.loadUser();
		this.loadRequests();
	},

	loadUser: function(){
		$.getJSON("/webpages/private/UserProfileServlet?op=profile", function(data){

		}).done(function(data){
			model.user = data;
			view.renderUser(model.user);

		}).fail(function(){
			alert("Errore!");
		});
	},

	loadRequests: function(){
		$.getJSON("/webpages/private/UserProfileServlet?op=userRequests", function(data){

		}).done(function(data){
			model.requests = data;
			view.renderRequests(model.requests);

		}).fail(function(){
			alert("Errore!");
		});
	},

	loadOffers: function(){
		$.getJSON("/webpages/private/UserProfileServlet?op=userOffers", function(data){

		}).done(function(data){
			model.offers = data;
			view.renderRequests(model.offers);

		}).fail(function(){
			alert("Errore!");
		});
	}
};

//VIEW
var view = {
	requestTemplate: undefined,
	offerTemplate: undefined,

	init: function(){
		//Compile request template
		var source = $("#request-template").html();
		this.requestTemplate = Handlebars.compile(source);

		//Compile offer template
		var source = $("#offers-template").html();
		this.offerTemplate = Handlebars.compile(source);
	},

	renderUser: function(user){
		var completeName = user.name + " " + user.surname;
		document.title = completeName + "| Sonstuf";
		$("#ucname").text(completeName);
		$("#telnum").text(user.telephone);
		$("#bdate").text(user.birthdate);
		$("#email").text(user.email);
		$("#rating-o").rating('update', user.rankO);
		$("#rating-r").rating('update', user.rankR);
	},

	renderRequests: function(requests){
		$("#requests").empty();

		for (var i = 0; i < requests.length; i++){
			var context = {
				title: requests[i].request.title,
				description: requests[i].request.description,
				place: requests[i].request.place,
				time: requests[i].request.time
			};

			var html = this.requestTemplate(context);
			$("#requests").append(html);
		}
	},

	renderOffers: function(offers){
		$("#offers").empty();

		for (var i = 0; i < offers.length; i++){
			var context = {
				title: offers[i].request.title,
				description: offers[i].request.description,
				user: offers[i].user.name,
				place: offers[i].request.place,
				time: offers[i].request.time,
				isInCharge: this.inChargeClass(offers[i].isInCharge)
			};

			var html = template(context);
			$("#offers").append(html);
		}
	},

	inChargeClass: function(isInCharge){
		if (isInCharge == true){
			return "in-charge";
		} else {
			return "";
		}
	}
};

