<%--
  Created by IntelliJ IDEA.
  User: nicola
  Date: 07/09/20
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Css/Header.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
        <header class="HeadList">
                <h1>Benvenuti sulla ${param.title} Di Scilab.com</h1>
                <img src="Immagini/LogoScilab.jpg" id="LogoSite">
                <nav class="mainNav">
                <ul id="LinkList" class="navList">
                        <li id="LinkItem" class="ListItem">
                                <a href="HomeServ" title="Pagina Principale">Home</a>
                                 <a href="${pageContext.request.contextPath}/ShowLog" title="Pagina Login">Login user</a>
                                <a href="showConUsServ" title="Pagina Social">Contattaci</a>
                                <a href="ShowNewsServ" title="Pagina News">Notizie</a>
                                <a href="showBioServ" title="Pagina sugli Sviluppatori">Chi siamo</a>
                                <a href="#" title="Pagina registrazione">Registrati</a>
                                <div class="SearchContainer">
                                        <form action="/RicServ" method="get">
                                <input type="text" placeholder="Cerca..." name="search">
                                                <button type="submit"><i class="fa fa-search"></i> </button>
                                        </form>
                                </div>
                        </li>
                </ul>
                </nav>
        </header>
</body></html>

