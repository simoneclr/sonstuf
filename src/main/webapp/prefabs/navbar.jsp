<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">

		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/webpages/home.jsp">Sonstuf</a>
		</div>

		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li><a href="/webpages/requestList.jsp">Naviga tra le richieste</a></li>
				<li><a href="/webpages/private/inserisciRichiesta.jsp">Nuova richiesta</a></li>
			</ul>
	
			<ul class="nav navbar-nav navbar-right" id="admin-user-nav" style="display: none">
				
			</ul>
			
			<ul class="nav navbar-nav navbar-right" id="not-logged-user-nav" style="display: none">
				<li><a href="/webpages/register.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				<li><a href="/webpages/login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right" id="logged-user-nav" style="display: none">
				<li id="admin-user-li" style="display: none"><a href="/webpages/private/admin/adminMenu.jsp"><span class="glyphicon glyphicon-user"></span> Admin Area</a></li>
				<li><a href="/webpages/private/userProfile.jsp"><span class="glyphicon glyphicon-user"></span> Il tuo profilo</a></li>
				<li><a id="logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
			</ul>
			
		</div>
	</div>
</nav>