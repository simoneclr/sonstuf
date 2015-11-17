<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:import url="/prefabs/header.jsp"></c:import>
	<link href="/css/enricoStyle.css" rel="stylesheet">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Dettaglio richiesta</title>

</head>
<body>
<c:import url="/prefabs/navbar.jsp"></c:import>

<div class="container centered">
	<div class="panel box-shadow">
		<div class="row">
			<div class="col-xs-4">

			</div>
		</div>
		<div class="row">
			<div class="col-xs-4">
				<img class="icon" src="http://image.freepik.com/free-photo/grass--garden_19-119630.jpg">
			</div>
			<div class="col-xs-4">
				<h3>
					Taglio erba
				</h3>
				<br>

				<div class="lib-row lib-desc">
					Cerco qualcuno che possa tagliare l'erba; <br>
					Ho tosaerba da mettere a disposizione. <br>
					Prato piano di 1000 m^2 <br>
					O.o
				</div>
			</div>
			<div class="col-xs-4">
				<ul>
					<li class="category">
						<p>giardinaggio</p>
					</li>
					<li>
						<p>casa mia</p>
					</li>
					<li>
						<p>when u want</p>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>

<hr>
<div class="container inCorso">
	<div class="row">
		<div class="[ col-xs-12 col-sm-offset-2 col-sm-8 ]">
			<ul class="event-list">
				<li class="offer">
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
							<li class="assign">
								<img src="http://media.licdn.com/mpr/mpr/shrinknp_400_400/p/5/005/067/1a9/39f45b1.jpg">
							</li>
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
