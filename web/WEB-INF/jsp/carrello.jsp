<%@ page import="Model.Carrello" %>
<%@ page import="Model.Prodotto" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nicola
  Date: 05/12/20
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Carrello</title>
  </head>
  <body>
                <% Carrello cart= (Carrello) session.getAttribute("carrello"); %>
                                <p>Dettagli Carrello</p>
                            <% for (Prodotto prod:cart.getListaProdotti()){%>
                                    <div class="ContainerProdCart">
                                    <span><%=prod.getIdprod()%> </span>
                                    <span><%=prod.getNome()%></span>
                                    <span> <%=prod.getDesc()%></span>
                                    <span><%=prod.getPrezzo()%></span>
                                <%}%>
                                <br>
                                <p>Prezzo totale:<%=cart.getSubTotale()%></p>
                             </div>
                  </body>
</html>
