<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="Model.Prodotto" %>
<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: nicola
  Date: 01/10/20
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Prodotto</title>
  </head>
  <body>
            <c:forEach var="prod" items="${prodscategory}">
                <div id="CatProdContainer">
                  <div class="CatProduct">
                    <p><c:out value="${prod.nome}"></c:out></p>
                      <p><c:out value="${prod.idprod}"></c:out></p>
                      <p><c:out value="${prod.quantprodotto}"></c:out></p>
                      <img class="ImgProd" src="/Immagini/<c:out value="${prod.idprod}.jpg"></c:out>">
                      <button class="BtnProd">
                                <a href="${pageContext.request.contextPath}/DetServ?idsearch=${prod.idprod}" class="ProdLink" target="_blank">Dettagli Prodotto</a>
                      </button>
                  </div>
                    </c:forEach>
                </div>

  </body>
</html>
