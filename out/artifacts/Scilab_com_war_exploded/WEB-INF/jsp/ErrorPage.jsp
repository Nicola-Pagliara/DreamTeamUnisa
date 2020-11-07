<%--
  Created by IntelliJ IDEA.
  User: nicola
  Date: 07/11/20
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
  <head>
    <title>ErrorPage: ${requestScope["javax.servlet.error.status_code"]}</title>
  </head>
  <body>
  <!--header-->
  <%@include file="Header.jsp"%>
  <%if(exception != null){%>
  <h1>Error ${requestScope["javax.servlet.error.status_code"]}: <%=exception.getClass().getSimpleName()%></h1>
  <p>
    There was an exception in the server: <br>
    <%=exception.getMessage()%>
    <%exception.printStackTrace(); //debug, rimuovere in seguito%>
  </p>
  <%} else{%>
  <h1>Error: ${requestScope["javax.servlet.error.status_code"]}</h1>
  <p>There was an error in the resource access process: <br>
    error ${requestScope["javax.servlet.error.status_code"]}.</p>
  <%}%>
  <%@include file="Footer.jsp"%> <!--footer-->
  
  </body>
</html>
