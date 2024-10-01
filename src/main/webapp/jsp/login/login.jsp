<%--
  Created by IntelliJ IDEA.
  User: Dejan
  Date: 1.10.2024.
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <link rel="stylesheet" type="text/css" href="login.css" media="screen" >
</head>
<body>
<main>
    <div class="row">
        <div class="colom-form">
            <div class="form-container">


<form method="POST" action="userGreeting.jsp">
    Korisnicko ime : <input type="text" name="korisnickoIme"/>
    Lozinka <input type="password" name="lozinka">
    <input type="submit" value="Prijavi se"/>
</form>
</div>
</div>
</div>
</main>
</body>
</html>
