<%@ page import="Model.Utente" %><%--
  Created by IntelliJ IDEA.
  User: nicola
  Date: 21/11/20
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Pannello Utente</title>
  </head>
  <body><% Utente usr= (Utente)session.getAttribute("usrlog");%>
            <p>Bevenuto utente:<%=usr.getNome()+usr.getCognome()%></p>
            <br>
            <p> Questo è  il tuo pannello di controllo</p>

  </body>
</html>
