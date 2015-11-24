/**
 * Created by gianluke on 19/11/15.
 */

$(document).ready(function () {
	$(".img_category").on("click",function(){
		if ($(this).hasClass("deselected")){
			$(this).css("border", "3px solid red");
			$(this).removeClass("deselected");
			$(this).addClass("selected");
		}
		else{
			$(this).css("border", "3px solid black");
			$(this).removeClass("selected");
			$(this).addClass("deselected");
		}
	});
});