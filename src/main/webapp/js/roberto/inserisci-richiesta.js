/**
 * Created by gianluke on 19/11/15.
 */

$(document).ready(function () {

	updateCategory();


});

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