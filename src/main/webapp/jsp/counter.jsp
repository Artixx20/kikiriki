<%@ page import="java.time.LocalDateTime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! public static final String INDIVIDUALNE_POSETE = "individualne posete";
    int brojPoseta = 0;%>
<html>
<head>
    <title>Brojac</title>
</head>
<body>
<%
    if (session.getAttribute(INDIVIDUALNE_POSETE)==null){
        session.setAttribute(INDIVIDUALNE_POSETE, 1);
    }else{
        int counter = (int) session.getAttribute(INDIVIDUALNE_POSETE);
        counter++;
        session.setAttribute(INDIVIDUALNE_POSETE, counter);
    }
%>
<h1>Counter</h1>
<p> Trenutno vreme <%=LocalDateTime.now()%></p>
<p>Broj poseta <%=++brojPoseta%></p>
<p>Individualne posete <%=session.getAttribute(INDIVIDUALNE_POSETE)%></p>
</body>
</html>
