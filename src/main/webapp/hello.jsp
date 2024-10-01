<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.util.Random" %>

<%--
  Created by IntelliJ IDEA.
  User: Dejan
  Date: 1.10.2024.
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Moj Prvi JSP page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<div style="padding: 20px">
<h1>demonstracija jednog izraza</h1>
<h2>4 vazne stvari kada je upitanju jsp tehnologija</h2>
<ol>
    <li>izrazi</li>
    <li>skripleti</li>
    <li>deklaracije</li>
    <li>direktive</li>
</ol>
<hr>
<h1>demonstracija jednog izraza</h1>
<p>trenutno vreme <%=LocalDateTime.now()%> </p>
    <hr>
    <h1>Demonstracija upotrebe skripleta</h1>
    <%
    Random random = new Random();
    int slucajanBroj= random.nextInt(10);
    if (slucajanBroj <=5){

    %> <p>mnogo sam Nesretan</p>
    <%}else{%><p>Mnogo sam Sretan</p>
    <%}%>
    <hr>
    <h1>Demo Deklaracija</h1>
<%! int counter = new Random().nextInt(10);%>
    <p>Vrednost counter : <%=counter%></p>
    <p>vrednost sluc broja : <%=slucajanBroj%></p>
    <hr>
    <h1>Demo upotrebe DIREKTIVA</h1>
    <%@include file="index.html"%>

</div>
</body>
</html>
