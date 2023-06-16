<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="EstudioCinema.model.bean.Diretor"%>
<%@page import="EstudioCinema.controller.ControllerDiretor"%>
<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Diretor dir = new Diretor(id);
    ControllerDiretor dirCont = new ControllerDiretor();
    dir = dirCont.buscar(dir);
    String pbusca = request.getParameter("PBUSCA");
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - DIRETOR</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR DIRETOR</h1>
        <form name="alterarDiretor" action="validaAlterarDiretor.jsp" method="post">
            Nome: <input type="text" name="NOME" value="<%=dir.getNome()%>"> <br>
            Formação: <input type="text" name="FORMACAO" value="<%=dir.getFormacao()%>"> <br>
            Quantidade de Filmes: <input type="text" name="QTDFILMES" value="<%=dir.getQtdFilmes()%>"> <br>
            ID do Filme: <input type="text" name="IDFILME" value="<%=dir.getIdF()%>"> <br>
            <input type="HIDDEN" name="ID" value="<%=dir.getId()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>"> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        <div>
    </body>
</html>