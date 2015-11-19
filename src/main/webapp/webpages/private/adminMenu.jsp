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
		<link href="../../css/style-gianluca.css" rel="stylesheet">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Admin_menù</title>

	</head>
	<body>
		<c:import url="/prefabs/navbar.jsp"></c:import>

		<div class="row">
			<div class="col-md-10 col-md-offset-1">
				<div class="panel panel-info  panel_admin_info">
					<div class="panel-heading panel_admin_heading">
						<h3 class="panel-title">
							<span class="glyphicon glyphicon-bookmark"></span> Quick Shortcuts</h3>
					</div>
				</div>
			</div>
		</div>



		<c:import url="/prefabs/footer.jsp"></c:import>
	</body>
</html>
