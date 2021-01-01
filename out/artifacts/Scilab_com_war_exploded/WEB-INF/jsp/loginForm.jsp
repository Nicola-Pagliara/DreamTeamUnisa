<%--
  Created by IntelliJ IDEA.
  User: nicola
  Date: 18/10/20
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
  </head>
  <body>
        <form action="${pageContext.request.contextPath}/LogServlet" method="post" target="_blank">
          
                <div class="LoginImgCointainer">
                    <img src="#" alt="#">
                </div>
                <div class="LoginContainer">
                <label for="user">Username:</label>
                <input type="text" id="user" name="username" value="username" placeholder="Inserisci nome utente"/> <br>
                <label for="pass">Password:</label>
                <input type="password" id="pass" name="password" value="password" placeholder="Inserisci password"/>
                  <button type="submit" class="BtnLog" value="Login"> Login</button>
                  <label>
                    <input type="checkbox" checked="checked"> Ricordati di me
                  </label>
                  <div class="container" style="background-color:#f1f1f1">
                    <button type="button" class="cancelbtn">cancella</button>
                    <span class="psw">Dimenticata la <a href="#">password?</a></span>
                  </div>
          </div>
        </form>
  </body>
</html>
