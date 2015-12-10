/**
 * Created by gianluke on 19/11/15.
 */

var arrayId=[];
$(document).ready(function () {

	updateCategory();
	updateImage();

});

function updateCategory(){

	var source = $("#category-template").html();
	var template = Handlebars.compile(source);

	var context;
	console.log("1");
	$.getJSON("/CategoriesServlet", function(json){

				for (var i = 0; i < json.length; i++) {
					context = {
						category: json[i].category,
						id: json[i].idcategory

					};

					var index=parseInt(json[i].idcategory);
					arrayId[index]=json[i].category;
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

function updateImage(){
	$("#category").click(function(){
		var category=$("#category").val();
		console.log("c"+category);
		var img=arrayId[category].replace(" ","_");
		$("#img").html("<img src=\"../../img/"+img+".jpeg\" style=\"width:350px ; height:180px\">");


	});
}