<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nicola
  Date: 01/11/20
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Dettagli Prodotto</title>
  </head>
  <body>
                <p> <%= request.getAttribute("notify")%></p>
                <br>
                <div class="DetProdContainer">
                <c:forEach var="DetProd" items="${dettprod}">
                <span><c:out value="${DetProd.nome}"></c:out></span>
                            <p> <c:out value="${DetProd.desc}"></c:out></p>
                          <p><c:out value="${DetProd.idprod}"></c:out> </p>
                </c:forEach>
                </div>
  </body>
</html>
