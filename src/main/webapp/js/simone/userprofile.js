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
		this.loadOffers();
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
			view.renderOffers(model.offers);

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
				reqid: requests[i].idRequest,
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
				offid: offers[i].idOffer,
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

