<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="EstudioCinema.model.bean.Usuario"%>
<%@page import="EstudioCinema.model.bean.Diretor"%>
<%@page import="EstudioCinema.controller.ControllerDiretor"%>
<%@page import="java.util.List"%>

<%
    String nome = request.getParameter("NOME");
    Diretor dir = new Diretor(nome);
    ControllerDiretor dircont = new ControllerDiretor();
    List<Diretor> dire = dircont.listar(dir);
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + nome+"&ID=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA DIRETOR</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="Id">Id</th>
                  <th data-field="Nome">Nome</th>
                  <th data-field="Formacao">Formacao</th>
                  <th data-field="QtdFilmes">Quantidade de Filmes</th>
                  <th data-field="NomeFilme">Nome do Filme</th>
                  <th data-field="Excluir">Excluir</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(dire.isEmpty())) { %>    
                <tbody>
                    <% for (Diretor listaDiretor : dire) { %>
                        <tr>
                            <td><%=listaDiretor.getId()%></td>
                            <td><%=listaDiretor.getNome()%></td>
                            <td><%=listaDiretor.getFormacao()%></td>
                            <td><%=listaDiretor.getQtdFilmes()%></td>
                            <td><%=listaDiretor.getF().getNome()%></td>
                            <% if (usuLogado.getTipo().equals("ADM")) { %>
                                <td><a href="excluirDiretor.jsp?<%=url + listaDiretor.getId()%>">Excluir</a></td>
                                <td><a href="alterarDiretor.jsp?<%=url + listaDiretor.getId()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>