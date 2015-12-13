<%--
  Created by IntelliJ IDEA.
  User: gianluke
  Date: 18/11/15
  Time: 13.35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<c:import url="/prefabs/header.jsp"></c:import>
		<link href="/css/style-gianluca.css" rel="stylesheet">
		<link href='https://fonts.googleapis.com/css?family=Karla&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Admin_menù</title>

	</head>
	<body>
		<c:import url="/prefabs/navbar.jsp"></c:import>

		<div class="row">
			<div class="col-md-10 col-md-offset-1 col-xs-12  col-sm-10 col-sm-offset-1">
				<div class="panel panel-info  panel_admin_info">
					<div class="panel-heading panel_admin_heading">
						<h3 class="panel-title panel_admin_title">
							<span class="glyphicon glyphicon-cog"></span>PANNELLO ADMIN</h3>
					</div>
					<div class="panel-body">
						<div class="row row_admin">
							<div class="col-xs-3 col-md-3 col-sm-3 col-md-offset-2 col-sm-offset-2">
								<a href="insertAnnouncementAdmin.jsp" class="btn btn-danger btn-lg" role="button"><span class="glyphicon glyphicon-plus"></span> <br/>Annuncio</a>
							</div>
							<div class="col-xs-10 col-md-7 col-sm-7">
								<p class="admin_p">Inserisci annuncio</p>
							</div>
						</div>
						<div class="row row_admin">
							<div class="col-xs-3 col-md-3 col-sm-3 col-md-offset-2 col-sm-offset-2">
								<a href="#" class="btn btn-success btn-lg" role="button"><span class="glyphicon glyphicon-list-alt"></span> <br/>Utenti</a>
							</div>
							<div class="col-xs-10 col-md-7 col-sm-7">
								<p class="admin_p">Visualizza lista utenti</p>
							</div>
						</div>
						<div class="row row_admin">
							<div class="col-xs-3 col-md-3 col-sm-3 col-md-offset-2 col-sm-offset-2">
								<a href="#" class="btn btn-primary btn-lg" role="button"><span class="glyphicon glyphicon-wrench"></span> <br/>Sistema</a>
							</div>
							<div class="col-xs-10 col-md-7 col-sm-7">
								<p class="admin_p">Impostazioni di sistema</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>



		<c:import url="/prefabs/footer.jsp"></c:import>
	</body>
</html>
