<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="EstudioCinema.model.bean.Roteirista"%>
<%@page import="EstudioCinema.controller.ControllerRoteirista"%>
<%@page import="EstudioCinema.model.bean.Filme"%>
<%@page import="EstudioCinema.controller.ControllerFilme"%>
<%@page import="EstudioCinema.model.bean.RoteiristaFilme"%>
<%@page import="EstudioCinema.controller.ControllerRoteiristaFilme"%>

<%
    ControllerRoteirista rotCont = new ControllerRoteirista();
    Roteirista rotEnt = new Roteirista("");
    List<Roteirista> rote = rotCont.listar(rotEnt);

    ControllerFilme filCont = new ControllerFilme();
    Filme filEnt = new Filme("");
    List<Filme> film = filCont.listar(filEnt);

    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    RoteiristaFilme rotFil = new RoteiristaFilme(id);
    ControllerRoteiristaFilme rotFilCont = new ControllerRoteiristaFilme();
    rotFil = rotFilCont.buscar(rotFil);
    String pbusca = request.getParameter("PBUSCA");


%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - ROTEIRISTA FILME</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR - ROTEIRISTA FILME</h1>
        <form name="alterarRelacaoRoteiristaFilme" action="validaAlterarRelacaoRoteiristaFilme.jsp" method="post">
            <table>
                <tr>
                    <td>Roteirista:</td>
                        <td>
                            <select NAME="ID_ROTEIRISTA" class="browser-default">
                                <% for (Roteirista rot : rote) { %>
                                    <% if( rot.getId() == rotFil.getIdR()) { %>
                                        <option selected value="<%=rot.getId()%>"><%=rot.getNome()%></option>
                                    <% } else { %>
                                        <option value="<%=rot.getId()%>"><%=rot.getNome()%></option>
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
                                    <% if( fil.getId()== rotFil.getIdF()) { %>
                                        <option selected value="<%=fil.getId()%>"><%=fil.getNome()%></option>
                                    <% } else { %>
                                        <option value="<%=fil.getId()%>"><%=fil.getNome()%></option>
                                    <% } %>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Titulo do Roteiro:</td>
                        <td><input type="text" name="TITULOROTEIRO" value="<%=rotFil.getTituloRoteiro()%>"></td>

                    </tr>
                </table>    
            <input type="HIDDEN" name="ID" value="<%=rotFil.getId()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>">
            <input type="submit" name="Enviar" value="OK">
        </form>
        <div>
    </body>
</html>