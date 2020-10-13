<%-- 
    Document   : home
    Created on : 12-Oct-2020, 10:29:26 PM
    Author     : cocog
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Home Page</h1>
        Hello ${username}<br><br>
        <form action="login" method="get">
            <input type="hidden" name="action" value="logout">
            <input type="submit" value="logout">
        </form>
    </body>
</html>
