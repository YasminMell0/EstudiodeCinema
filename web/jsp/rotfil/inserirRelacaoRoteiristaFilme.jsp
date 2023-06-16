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

%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>INSERIR ROTEIRISTA FILME</title>
    <body>
        <div class="container"/>
            <h1>Inseri Roteirista Filme</h1>
            <form name="inseriRelacaoRoteiristaFilme" action="validaRelacaoRoteiristaFilme.jsp" method="POST">
                <table>
                    <tr>
                        <td>Roteirista:</td>
                        <td>
                            <select NAME ="ID_ROTEIRISTA" class="browser-default">
                                <% for (Roteirista rot : rote) { %>
                                    <option value="<%=rot.getId()%>"><%=rot.getNome()%></option>
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
                        <td>Titulo do Roteiro:</td>
                        <td><input type="text" name="TITULOROTEIRO" value=""></td>
                    </tr>
                </table>    
                <input type="submit" name="Enviar" value="Enviar">  <br>
            </form>
        </div>                     
    </body>
</html>
