<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:import url="/prefabs/header.jsp"></c:import>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Dettaglio richiesta</title>

</head>
<body>
<c:import url="/prefabs/navbar.jsp"></c:import>

<div class="request">
	<br>
	<br>
	<br>
	<br>
	<br>

	<div class="container" style="background-color: #1c699d">
		<img class="col-xs-4 img-responsive img-circle" src="http://placehold.it/2048x1024">

		<div class="col-xs-8">
			categoryName
			<br>
			requestDescription
		</div>
	</div>
</div>
<br>
<br>

<div class="container">
	<div class="row">
		<div class="[ col-xs-12 col-sm-offset-2 col-sm-8 ]">
			<ul class="event-list">
				<li class = "offer">
					<time datetime="2014-07-20">
						<span class="day">4</span>
						<span class="month">Jul</span>
						<span class="year">2014</span>
						<span class="time">ALL DAY</span>
					</time>
					<div class="userInfo">
						nameSur <br>
						rankO
					</div>
					<div class="info">
						<h2 class="title">Fellin</h2>
						<p class="desc">si è offerto per aiutarti</p>
					</div>
					<div class="social">
						<ul>
							<li class = "assign"><img class = "icon" src = "http://media.licdn.com/mpr/mpr/shrinknp_400_400/p/5/005/067/1a9/39f45b1.jpg"></li>
						</ul>
					</div>
				</li>
			</ul>
		</div>
	</div>
</div>

<br>
<br>

<c:import url="/prefabs/footer.jsp"></c:import>
</body>
</html>
