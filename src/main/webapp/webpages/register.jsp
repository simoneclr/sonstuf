<%--
  Created by IntelliJ IDEA.
  User: gianluke
  Date: 16/11/15
  Time: 11.04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form>
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:import url="/prefabs/header.jsp"></c:import>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>

</head>
    <body>

        <c:import url="/prefabs/navbar.jsp"></c:import>

        <br>
        <br>
        <br>
        <br>
        <br>
        <br>



        <div class="container">
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <h2>Registrati</h2>
                    <hr class="colorgraph">
                </div>
            </div>
            <form>
                <div class="form-group col-md-offset-2 col-md-3 col-sm-3 col-sm-offset-2">
                    <label>Nome</label>
                    <input type="text" name="name" class="form-control" id="" value="">
                </div>
                <div class="form-group col-md-offset-2 col-md-3 col-sm-3 col-sm-offset-2">
                    <label>Cognome</label>
                    <input type="text" name="surname" class="form-control" id="" value="">
                </div>
                <div class="form-group col-md-offset-2 col-md-3 col-sm-3 col-sm-offset-2">
                    <label>Data di nascita</label>
                    <input type="date" name="birthdate" class="form-control" id="" value="">
                </div>
                <div class="form-group col-md-offset-2 col-md-3 col-sm-3 col-sm-offset-2">
                    <label>Email</label>
                    <input type="email" name="email" class="form-control" id="" value="">
                </div>
                <div class="form-group col-md-offset-2 col-md-3 col-sm-3 col-sm-offset-2">
                    <label>Telefono</label>
                    <input type="tel" name="phone" class="form-control" id="" value="">
                </div>
                <div class="form-group col-md-offset-2 col-md-3 col-sm-3 col-sm-offset-2">
                    <label>Password</label>
                    <input type="password" name="password1" class="form-control" id="" value="">
                </div>
                <div class="form-group col-md-offset-2 col-md-3 col-sm-3 col-sm-offset-2">
                    <label>Conferma password</label>
                    <input type="password" name="password2" class="form-control" id="" value="">
                </div>
                <div id="button_submit" class="form-group col-md-offset-4 col-md-2 col-sm-2 col-sm-offset-2">
                    <input type="submit" name="enter" class="btn btn-success" id="" value="Accedi">
                </div>
            </form>
        </div>

        <c:import url="/prefabs/footer.jsp"></c:import>

    </body>
</html>
