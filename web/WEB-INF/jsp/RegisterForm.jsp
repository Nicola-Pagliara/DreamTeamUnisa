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
  </head>
  <body>
  <div id="SignUpContainer">
                    <form action="${pageContext.request.contextPath}/RegServlet" method="post" style="border:1px solid black">

                                <h1> Registrazione a SciLab</h1>
                                <p> Per favore riempi tutti i campi del form correttamente, non lasciare campi vuoti.</p>
                                <div class="field">
                                        <label for id="nome"> Nome:</label>
                                        <input type="text" name="nome" placeholder="Inserisci il nome..." required="required" autocomplete="off">
                                </div>
                                <br>
                                <div class="field">
                                        <label for id="Cognome">Cognome:</label>
                                        <input type="text" name="cognome" placeholder="Inserisci il cognome..." required="required" autocomplete="off">
                                </div>
                                <br>
                                <div class="field">
                                            <label for id="Cf">Codice Fiscale:</label>
                                            <input type="text" name="Cf" placeholder="Inserisci il codice fiscale..." required="required" autocomplete="off">
                                </div>
                                    <br>
                                <div class="field">


                                </div>





         </form>
  </div>
  </body>
</html>
