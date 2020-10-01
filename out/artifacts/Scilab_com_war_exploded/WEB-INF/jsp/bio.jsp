<%--
  Created by IntelliJ IDEA.
  User: nicola
  Date: 12/09/20
  Time: 01:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    section{
        display:flex !important;
        justify-content:center;
        width:80%;
        margin:auto;
    }
    .block div{
        text-align: center;
        padding: 10px 10px;
        margin: 10px 20px;
    }
    .text p{
        text-align: center;
        color: black;
        padding: 10px 10px;
        margin: 10px 20px;
    }

</style>
<body>

<%@include file="Header.jsp"%>
<section>
    <div class="block">
        <p class="text">
            <br>
            <br>
            SciLab è un sito che si occupa della vendita di articoli utilizzati nella ricerca scientifica di Fisica, Chimica, Matematica e informatica
            andando a consolidare le esigenze di tutta la tipologia di clientela; dal principiante alle prime armi fino ad arrivare al ricercatore più esperto.
            la spedizione è rapida e le consegne rispettano sempre le date di scadenza.
            i metodi di pagamento sono: contrassegno, postepay, paypal, iban e carta di credito.
            Le consegne arrivano ovunque tu voglia e il servizio clienti è sempre a disposizione per maggiori informazioni cliccate nelle nostre pagine social.
            <br>
            <br>
            <q>Per scoprire qualcosa, è meglio eseguireesperimenti accurati che impegnarsi in profonde discussioni filosofiche.</q>
        </p>

    </div>
</section>
<%@include file="Footer.jsp"%>
</body>
</html>
