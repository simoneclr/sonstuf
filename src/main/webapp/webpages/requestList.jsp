<%--
  Created by IntelliJ IDEA.
  User: gianluke
  Date: 16/11/15
  Time: 11.04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
            <h2>Lista richieste</h2>
            <hr class="colorgraph">
        </div>
    </div>

    <br>

    <div class="row">
        <div class="col-md-offset-1 col-md-2">
            <label>Categoria</label>
            <input type="text" name="category" class="form-control" id="" value="">
        </div>
        <div class="col-md-offset-1 col-md-2">
            <label>Nome</label>
            <input type="text" name="nome" class="form-control" id="" value="">
        </div>
        <div class="col-md-offset-1 col-md-2">
            <label>Luogo</label>
            <input type="text" name="place" class="form-control" id="" value="">
        </div>

        <div class="col-md-offset-1 col-md-2">
            <button class="btn btn-primary" style="margin-top: 25px" id="">Cerca </button>
        </div>
    </div>

    <br>
    <br>

    <div class="list row">
        <div class="request col-md-offset-1 col-md-10">
            <div class="category">
                
                <div class="nameCategory">Category</div>
                
                <img src="../img/gardening.jpg" class="imgCategory">
            </div>

            <div class="description">
                <p class="shortDescription">
                    Coltivare le ortensie è un'arte ma per ottenere dei buoni risultati si
                    devono assicurare alle piante le condizioni climatiche adeguate ed in questa
                    sezione potrete scoprire tutti i segreti per coltivare le ortensie e riconoscere
                    dal loro aspetto eventuali problemi che...

                </p>

                <div class="info">
                    <span class="place">Dambel</span>
                    <span class="time">Sabato mattina</span>
                    <span class="incompleteName">Gianlu94</span>
                </div>
            </div>
        </div>

        <div class="request col-md-offset-1 col-md-10">
            request2
        </div>

    </div>
</div>

<c:import url="/prefabs/footer.jsp"></c:import>

</body>
</html>
