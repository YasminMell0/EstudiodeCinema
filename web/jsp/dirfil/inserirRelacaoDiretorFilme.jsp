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
    Diretor dirEnt = new Diretor("");
    List<Diretor> dire = dirCont.listar(dirEnt);

    ControllerFilme filCont = new ControllerFilme();
    Filme filEnt = new Filme("");
    List<Filme> film = filCont.listar(filEnt);

%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>INSERIR DIRETOR FILME</title>
    <body>
        <div class="container"/>
            <h1>Inseri Diretor Filme</h1>
            <form name="inseriRelacaoDiretorFilme" action="validaRelacaoDiretorFilme.jsp" method="POST">
                <table>
                    <tr>
                        <td>Diretor:</td>
                        <td>
                            <select NAME ="ID_DIRETOR" class="browser-default">
                                <% for (Diretor dir : dire) { %>
                                    <option value="<%=dir.getId()%>"><%=dir.getNome()%></option>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Filme:</td>
                        <td>
                            <select NAME="ID_FILME" class="browser-default">
                                <% for (Filme fil : film) { %>
                                    <option value="<%=fil.getId()%>"><%=fil.getNome()%></option>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Cinematografia:</td>
                        <td><input type="text" name="CINEMATOGRAFIA" value=""></td>
                    </tr>
                </table>    
                <input type="submit" name="Enviar" value="Enviar">  <br>
            </form>
        </div>                     
    </body>
</html>
