<%@ page import="java.util.List" %>
<%@ page import="Model.Categoria" %><%--
  Created by IntelliJ IDEA.
  User: nicola
  Date: 17/05/20
  Time: 03:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<html>
<head>
  <title>Scilab.Com-HomePage</title>
  <link rel="stylesheet" href="Css/Home.css">
  <meta charset="UTF-8">
</head>
<style>
  .CategoryContainer > img.ImgCat{
    width: 200px;
    height: 200px;
  }
  body{
    background-image: url("/Immagini/ImgCategory/wallpapperScience.jpg");
  }
</style>
<body>
<%@include file="WEB-INF/jsp/Header.jsp"%>
<div id="HomeCatContenier">
<c:forEach var="categoria" items='${categorie}'>
  <div class="CategoryContainer">
    <span> <c:out value="${categoria.nome}"></c:out></span>
    <p><c:out value="${categoria.descrizione}"></c:out> </p>
    <p hidden><c:out value="${categoria.idcategory}"></c:out></p>
    <img class="ImgCat" alt="${categoria.pathimageicona}.png" src="${pageContext.request.contextPath}/Immagini/ImgCategory/<c:out value="${categoria.pathimageicona}.png" ></c:out>">
    <button style="display: block" title="Elenco prodotto"  class="btnProd">
      <a  class="LinkProduct" href="${pageContext.request.contextPath}/CatServ?Idcat=${categoria.idcategory}" style="color: blueviolet" target="_blank">Info Prodotto</a>
    </button>
  </div>
</c:forEach>
</div>
<%@include file="WEB-INF/jsp/Footer.jsp"%>
</body>
</html>
