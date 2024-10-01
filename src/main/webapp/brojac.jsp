
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Brojac poseta</title>
</head>
<body>
<h1>Brojac koji voli brojat posete</h1>
<%!
    int counter = 0;
synchronized int incrementCount(){
    counter++;
            return counter;
}


%>
<h3>posetili ste ovu stranicu <%=incrementCount()%></h3>
<p>thread koji obradjuje request <%=Thread.currentThread().getName()%></p>
</body>
</html>
