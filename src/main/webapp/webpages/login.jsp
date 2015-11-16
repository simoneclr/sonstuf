<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <div style="color: #FF0000">${message}</div>
        <form method="POST" action="check-login">
            <p>
                username:
                <input type="text" name="username" placeholder="username">
            </p>
            <p>
                password:
                <input type="password" name="password" placeholder="password">
            </p>
            <p>
                <input type="submit" value="login">
                <input type="reset" value="reset">
            </p>
        </form>
    </body>
</html>
