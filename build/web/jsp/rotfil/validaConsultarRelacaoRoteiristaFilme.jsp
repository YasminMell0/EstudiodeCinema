<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="EstudioCinema.model.bean.Usuario"%>
<%@page import="EstudioCinema.controller.ControllerUsuario"%>
<%@page import="EstudioCinema.model.bean.RoteiristaFilme"%>
<%@page import="EstudioCinema.controller.ControllerRoteiristaFilme"%>

<%
    String tituloRoteiro = request.getParameter("TITULOROTEIRO");
    RoteiristaFilme rotfil = new RoteiristaFilme(tituloRoteiro);
    ControllerRoteiristaFilme rotfilcont = new ControllerRoteiristaFilme();
    List<RoteiristaFilme> rotfilme = rotfilcont.listar(rotfil);
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + rotfil.getTituloRoteiro()+"&ID=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA USUÁRIOS</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="IdRoteiristaFilme">Id</th>
                  <th data-field="IdRoteirista">IdRoteirista</th>
                  <th data-field="NomeRoteirista">NomeRoteirista</th>
                  <th data-field="IdFilme">IdFilme</th>
                  <th data-field="NomeFilme">NomeFilme</th>
                  <th data-field="TituloRoteiro">TituloRoteiro</th>
                  <th data-field="Excluir">Excluir</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(rotfilme.isEmpty())) { %>    
                <tbody>
                    <% for (RoteiristaFilme listaRoteiristaFilme : rotfilme) { %>
                        <tr>
                            <td><%=listaRoteiristaFilme.getId()%></td>
                            <td><%=listaRoteiristaFilme.getIdR()%></td>
                            <td><%=listaRoteiristaFilme.getR().getNome()%></td>
                            <td><%=listaRoteiristaFilme.getIdF()%></td>
                            <td><%=listaRoteiristaFilme.getF().getNome()%></td>
                            <td><%=listaRoteiristaFilme.getTituloRoteiro()%></td>
                            <% if (usuLogado.getTipo().equals("ADM")) { %>
                                <td><a href="excluirRelacaoRoteiristaFilme.jsp?<%=url + listaRoteiristaFilme.getId()%>">Excluir</a></td>
                                <td><a href="alterarRelacaoRoteiristaFilme.jsp?<%=url + listaRoteiristaFilme.getId()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>