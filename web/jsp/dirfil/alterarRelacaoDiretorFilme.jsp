<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="EstudioCinema.model.bean.Diretor"%>
<%@page import="EstudioCinema.controller.ControllerDiretor"%>
<%@page import="EstudioCinema.model.bean.Filme"%>
<%@page import="EstudioCinema.controller.ControllerFilme"%>
<%@page import="EstudioCinema.model.bean.DiretorFilme"%>
<%@page import="EstudioCinema.controller.ControllerDiretorFilme"%>

<%
    ControllerDiretor dirCont = new ControllerDiretor();
    Diretor df = new Diretor("");
    List<Diretor> dire = dirCont.listar(df);

    ControllerFilme filCont = new ControllerFilme();
    Filme filEnt = new Filme("");
    List<Filme> film = filCont.listar(filEnt);

    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    DiretorFilme dirFil = new DiretorFilme(id);
    ControllerDiretorFilme dirFilCont = new ControllerDiretorFilme();
    dirFil = dirFilCont.buscar(dirFil);
    String pbusca = request.getParameter("PBUSCA");


%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - DIRETOR FILME</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR - DIRETOR FILME</h1>
        <form name="alterarRelacaoDiretorFilme" action="validaAlterarRelacaoDiretorFilme.jsp" method="post">
            <table>
                <tr>
                    <td>Diretor:</td>
                        <td>
                            <select NAME="ID_DIRETOR" class="browser-default">
                                <% for (Diretor diret : dire) { %>
                                    <% if( diret.getId() == dirFil.getIdD()) { %>
                                        <option selected value="<%=diret.getId()%>"><%=diret.getNome()%></option>
                                    <% } else { %>
                                        <option value="<%=diret.getId()%>"><%=diret.getNome()%></option>
                                    <% } %>
                                <% } %>
                            </select> 
                        </td>
                </tr>
                <tr>
                        <td>Filme:</td>
                        <td>
                            <select NAME ="ID_FILME" class="browser-default">
                                <% for (Filme fil : film) { %>
                                    <% if( fil.getId()== dirFil.getIdF()) { %>
                                        <option selected value="<%=fil.getId()%>"><%=fil.getNome()%></option>
                                    <% } else { %>
                                        <option value="<%=fil.getId()%>"><%=fil.getNome()%></option>
                                    <% } %>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Cinematografia:</td>
                        <td><input type="text" name="CINEMATOGRAFIA" value="<%=dirFil.getCinematografia()%>"></td>

                    </tr>
                </table>    
            <input type="HIDDEN" name="ID" value="<%=dirFil.getId()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>">
            <input type="submit" name="Enviar" value="OK">
        </form>
        <div>
    </body>
</html>