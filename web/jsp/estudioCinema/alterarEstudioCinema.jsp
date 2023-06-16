<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="EstudioCinema.model.bean.EstudioCinema"%>
<%@page import="EstudioCinema.controller.ControllerEstudioCinema"%>
<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    EstudioCinema est = new EstudioCinema(id);
    ControllerEstudioCinema estCont = new ControllerEstudioCinema();
    est = estCont.buscar(est);
    String pbusca = request.getParameter("PBUSCA");
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - ESTUDIO DE CINEMA</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR ESTUDIO DE CINEMA</h1>
        <form name="alterarEstudioCinema" action="validaAlterarEstudioCinema.jsp" method="post">
            Nome: <input type="text" name="NOME" value="<%=est.getNome()%>"> <br>
            Data de Criação: <input type="text" name="DATACRIACAO" value="<%=est.getDataCriacao()%>"> <br>
            ID do Filme: <input type="text" name="IDF" value="<%=est.getIdF()%>"> <br>
            ID do Diretor: <input type="text" name="IDD" value="<%=est.getIdD()%>"> <br>
            ID do Roteirista: <input type="text" name="IDR" value="<%=est.getIdR()%>"> <br>
            <input type="HIDDEN" name="ID" value="<%=est.getId()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>"> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        <div>
    </body>
</html>