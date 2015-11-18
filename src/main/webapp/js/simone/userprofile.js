//Static, temporary data
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
			"categoryDescription" : "Lorem ipsum bla bla bla",
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
			"categoryDescription" : "Lorem ipsum bla bla bla",
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
			"categoryDescription" : "Lorem Ipsum bla bla bla",
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
			"categoryDescription" : "Lorem Ipsum bla bla bla",
			"place" : "Povo",
			"time" : "11:00-16:00",
			"postTimestamp" : "omg!"}
	}];

$(document).ready(function(){

	updatePersonalData();

	updateUserRatings();

});

function updatePersonalData(){
	$("#ucname").text(user.name + " " + user.surname);
	$("#telnum").text(user.telephone);
	$("#bdate").text(user.birthdate);
	$("#email").text(user.telephone);
}

function updateUserRatings(){
	$("#rating-o").rating('update', user.rankO);

	$("#rating-r").rating('update', user.rankR);
}