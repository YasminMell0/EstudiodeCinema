<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="EstudioCinema.model.bean.Roteirista"%>
<%@page import="EstudioCinema.controller.ControllerRoteirista"%>
<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Roteirista rot = new Roteirista(id);
    ControllerRoteirista rotCont = new ControllerRoteirista();
    rot = rotCont.buscar(rot);
    String pbusca = request.getParameter("PBUSCA");
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - ROTEIRISTA</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR ROTEIRISTA</h1>
        <form name="alterarRoteirista" action="validaAlterarRoteirista.jsp" method="post">
            Nome: <input type="text" name="NOME" value="<%=rot.getNome()%>"> <br>
            Formação: <input type="text" name="FORMACAO" value="<%=rot.getFormacao()%>"> <br>
            Quantidade de Filmes: <input type="text" name="QTDFILMES" value="<%=rot.getQtdFilmes()%>"> <br>
            ID do Filme: <input type="text" name="IDFILME" value="<%=rot.getIdF()%>"> <br>
            <input type="HIDDEN" name="ID" value="<%=rot.getId()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>"> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        <div>
    </body>
</html>