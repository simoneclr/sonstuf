$(document).ready(function () {
	var source = $("#request").html();
	var template = Handlebars.compile(source);
	var context = {
		REQUEST_IMAGE: "http://media.lavorincasa.it/blog/giardinaggio/2013/03/lasagna3.jpg",
		REQUEST_TITLE: "Orto",
		REQUEST_DESCRIPTION: "Cerco una persona che possa aiutarmi a togliere le erbacce dall'orto",
		PLACE: "Dambel",
		TIME: "22/12/1994"
	};
	var requestHtml = template(context);

	$("#requestContainer").empty().append(requestHtml);
	$(".userName").empty().append("AliceF");
});