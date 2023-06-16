<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="EstudioCinema.model.bean.Filme"%>
<%@page import="EstudioCinema.controller.ControllerFilme"%>
<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Filme fil = new Filme(id);
    ControllerFilme filCont = new ControllerFilme();
    fil = filCont.buscar(fil);
    String pbusca = request.getParameter("PBUSCA");
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - FILME</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR FILME</h1>
        <form name="alterarFilme" action="validaAlterarFilme.jsp" method="post">
            Nome: <input type="text" name="NOME" value="<%=fil.getNome()%>"> <br>
            Gênero <input type="text" name="GENERO" value="<%=fil.getGenero()%>"> <br>
            Trama Principal: <input type="text" name="TRAMAPRINCIPAL" value="<%=fil.getTramaPrincipal()%>"> <br>
            Ano de Lançamento: <input type="text" name="ANOLANC" value="<%=fil.getAnoLanc()%>"> <br>
            Descrição: <input type="text" name="DESC" value="<%=fil.getDesc()%>"> <br>
            <input type="HIDDEN" name="ID" value="<%=fil.getId()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>"> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        <div>
    </body>
</html>