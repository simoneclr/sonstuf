<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link href="/css/bootstrap.min.css" rel="stylesheet">
        <link href="/css/material-design-iconic-font.min.css" rel="stylesheet">
        <link href="/css/jquery.bxslider.css" rel="stylesheet">
        <link href="/css/cinema.css" rel="stylesheet">
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <script src="/js/jquery-1.11.3.min.js"></script>
        <script src="/js/jquery.bxslider.min.js"></script>
        <title>Login</title>
    </head>
    <body>
        <header>
            <nav class="navbar navbar-default navbar-fixed-top">
                <div class="container">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="index.jsp"><i class="zmdi zmdi-movie-alt zmdi-right-8"></i>Home</a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="index.jsp"><i class="zmdi zmdi-home zmdi-right-8"></i>Home</a></li>
                            <li><a href="index.jsp"><i class="zmdi zmdi-movie zmdi-right-8"></i>Film</a></li>
                            <li><a href="index.jsp"><i class="zmdi zmdi-calendar-check zmdi-right-8"></i>Spettacoli</a></li>
                            <li class="dropdown" id="menu">
                                <%@ include file="menu.jsp" %>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>