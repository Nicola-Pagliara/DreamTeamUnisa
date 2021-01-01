<%--
  Created by IntelliJ IDEA.
  User: nicola
  Date: 07/11/20
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Registrazione Successo</title>
  </head>
  <body>
            <p> Congratulazioni Hai completato con successo la registrazione !!</p>
                    <br>
            <span> Clicca sul link per effettuare il Login</span>
                    <a href="${pageContext.request.contextPath}/ShowLog" target="_self">Login</a>
  </body>
</html>
