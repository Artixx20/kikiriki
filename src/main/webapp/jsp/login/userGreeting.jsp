<%--
  Created by IntelliJ IDEA.
  User: Dejan
  Date: 1.10.2024.
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" class="ba.smoki.kikiriki.four.User" scope="session"/>
<jsp:setProperty name="user" property="userName" param="korisnickoIme"/>
<jsp:setProperty name="user" property="password" param="lozinka"/>
<html>
<head>
    <title>Pozdrav User</title>
    <link rel="stylesheet" type="text/css" href="login.css" media="screen" >
</head>
<body>
<%
String message = user.login()? "Logovan si" : "Nisi logovan";
%>
<h1>pozdrav <%=user%></h1>
<p><%=message%></p>
</body>
</html>
