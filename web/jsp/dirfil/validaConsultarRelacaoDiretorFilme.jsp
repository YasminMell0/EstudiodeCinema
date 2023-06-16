<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="EstudioCinema.model.bean.Usuario"%>
<%@page import="EstudioCinema.controller.ControllerUsuario"%>
<%@page import="EstudioCinema.model.bean.DiretorFilme"%>
<%@page import="EstudioCinema.controller.ControllerDiretorFilme"%>

<%
    String cinematografia = request.getParameter("CINEMATOGRAFIA");
    DiretorFilme dirfil = new DiretorFilme(cinematografia);
    ControllerDiretorFilme dirfilcont = new ControllerDiretorFilme();
    List<DiretorFilme> dirfilme = dirfilcont.listar(dirfil);
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + dirfil.getCinematografia()+"&ID=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA USUÁRIOS</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="IdDiretorFilme">Id</th>
                  <th data-field="IdDiretor">IdDiretor</th>
                  <th data-field="NomeDiretor">NomeDiretor</th>
                  <th data-field="IdFilme">IdFilme</th>
                  <th data-field="NomeFilme">NomeFilme</th>
                  <th data-field="Cinematografia">Cinematografia</th>
                  <th data-field="Excluir">Excluir</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(dirfilme.isEmpty())) { %>    
                <tbody>
                    <% for (DiretorFilme listaDiretorFilme : dirfilme) { %>
                        <tr>
                            <td><%=listaDiretorFilme.getId()%></td>
                            <td><%=listaDiretorFilme.getIdD()%></td>
                            <td><%=listaDiretorFilme.getD().getNome()%></td>
                            <td><%=listaDiretorFilme.getIdF()%></td>
                            <td><%=listaDiretorFilme.getF().getNome()%></td>
                            <td><%=listaDiretorFilme.getCinematografia()%></td>
                            <% if (usuLogado.getTipo().equals("ADM")) { %>
                                <td><a href="excluirRelacaoDiretorFilme.jsp?<%=url + listaDiretorFilme.getId()%>">Excluir</a></td>
                                <td><a href="alterarRelacaoDiretorFilme.jsp?<%=url + listaDiretorFilme.getId()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>