<%--
  Created by IntelliJ IDEA.
  User: nicola
  Date: 25/10/20
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Registrazione</title>
      <link href="${pageContext.request.contextPath}/Css/RegisterForm.css" rel="stylesheet">
  </head>
  <body>
  <%@include file="/WEB-INF/jsp/Header.jsp"%>
  <div id="SignUpContainer">
                    <form action="${pageContext.request.contextPath}/RegServlet" method="post" style="border:1px solid black">

                                <h1> Registrazione a SciLab</h1>
                                <p> Per favore riempi tutti i campi del form correttamente, non lasciare campi vuoti.</p>
                                <div class="field">
                                        <input type="text" name="name" placeholder="Inserisci il nome..." required="required" autocomplete="off">
                                </div>
                                <br>
                        <div class="field">
                            <input type="text" name="username" placeholder="Inserisci l'Username.." required="required" autocomplete="off">
                        </div>
                        <br>
                        <div class="field">
                            <input type="password" name="password" placeholder="Inserisci Password.." required="required" autocomplete="off">
                        </div>
                        <br>
                        <div class="field">
                            <input  type="password"  name="passconferma" placeholder="Conferma Password.." required="required" autocomplete="off">
                        </div>
                        <br>
                        <div class="signup-btn">
                            <button title="Registrazione">
                                <a class="signup-button"  href="${pageContext.request.contextPath}/RegServlet">Registrati</a>
                            </button>
                        </div>
         </form>
  </div>
  <%@include file="/WEB-INF/jsp/Footer.jsp"%>
  </body>
</html>
