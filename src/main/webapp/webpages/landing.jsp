<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
	<c:import url="/prefabs/header.jsp"></c:import>
	<title>Title</title>
</head>

<body>

	<c:import url="/prefabs/navbar.jsp"></c:import>

	<div class="jumbotron">
		<div class="container">
			<h1> Hello, world! </h1>
			<p>...</p>
			<p> <a class="btn btn-primary btn-lg" href="#" role="button"> Learn more </a> </p>
		</div>
	</div>

	<div class="container">

		<div class="row">
			<div class="col-md-4">
				<h2> Hello, world! </h2>
				<p>
					Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum
					nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
				</p>
				<p> <a class="btn btn-primary btn-lg" href="#" role="button"> Learn more </a> </p>
			</div>
			<div class="col-md-4">
				<h2> Hello, world! </h2>
				<p>
					Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum
					nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
				</p>
				<p> <a class="btn btn-primary btn-lg" href="#" role="button"> Learn more </a> </p>
			</div>
			<div class="col-md-4">
				<h2> Hello, world! </h2>
				<p>
					Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum
					nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
				</p>
				<p> <a class="btn btn-primary btn-lg" href="#" role="button"> Learn more </a> </p>
			</div>
		</div>
		<hr>
	</div>

	<!-- This is the main container of the entire page -->
	<div class="container">
		<h1>
			Person form
		</h1>
		<hr>

		<form>

			<div class="row">
				<div class="col-md-2">
					<div class="form-group">
						<label for="titleInput"> Title </label>
						<input type="text" class="form-control" id="titleInput" placeholder="Mr.">
					</div>
				</div>
				<div class="col-md-5">
					<div class="form-group">
						<label for="firstName"> First Name </label>
						<input type="text" class="form-control" id="firstName" placeholder="Paolo">
					</div>
				</div>
				<div class="col-md-5">
					<div class="form-group">
						<label for="lastName"> Last Name </label>
						<input type="text" class="form-control" id="lastName" placeholder="Rossi">
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label for="genderSel"> Gender </label>
						<select class="form-control" id="genderSel">
							<option> M </option>
							<option> F </option>
						</select>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label for="dateOBirth"> Date Of Birth </label>
						<input type="date" id="dateOBirth" class="form-control" placeholder="dd/mm/yyyy">
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label for="txtStreet"> Address </label>
						<input type="text" class="form-control" id="txtStreet" placeholder="Street">
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="City">
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="State">
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Post Code">
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<select class="form-control">
							<option> Germany </option>
							<option> Italy </option>
							<option> U.K. </option>
							<option> U.S.A. </option>
						</select>
					</div>
				</div>
			</div>

			<hr>
			<div class="row">
				<div class="col-md-11"> </div>
				<div class="col-md-1">
					<div class="form-group">
						<button type="submit" class="btn btn-primary"> Submit </button>
					</div>
				</div>
			</div>


		</form>
	</div>

	<c:import url="/prefabs/footer.jsp"></c:import>

</body>
</html>
