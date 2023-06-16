<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="EstudioCinema.model.bean.Usuario"%>
<%@page import="EstudioCinema.model.bean.EstudioCinema"%>
<%@page import="EstudioCinema.controller.ControllerEstudioCinema"%>
<%@page import="java.util.List"%>

<%
    String nome = request.getParameter("NOME");
    EstudioCinema est = new EstudioCinema(nome);
    ControllerEstudioCinema estcont = new ControllerEstudioCinema();
    List<EstudioCinema> estu = estcont.listar(est);
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + nome+"&ID=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA ESTUDIO DE CINEMA</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="Id">Id</th>
                  <th data-field="Nome">Nome</th>
                  <th data-field="DataCriacao">Data da Criação</th>
                  <th data-field="NomeFilme">Nome do Filme</th>
                  <th data-field="NomeDiretor">Nome do Diretor</th>
                  <th data-field="NomeRoteirista">Nome do Roteirista</th>
                  <th data-field="Excluir">Excluir</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(estu.isEmpty())) { %>    
                <tbody>
                    <% for (EstudioCinema listaEstudioCinema : estu) { %>
                        <tr>
                            <td><%=listaEstudioCinema.getId()%></td>
                            <td><%=listaEstudioCinema.getNome()%></td>
                            <td><%=listaEstudioCinema.getDataCriacao()%></td>
                            <td><%=listaEstudioCinema.getF().getNome()%></td>
                            <td><%=listaEstudioCinema.getD().getNome()%></td>
                            <td><%=listaEstudioCinema.getR().getNome()%></td>
                            <% if (usuLogado.getTipo().equals("ADM")) { %>
                                <td><a href="excluirEstudioCinema.jsp?<%=url + listaEstudioCinema.getId()%>">Excluir</a></td>
                                <td><a href="alterarEstudioCinema.jsp?<%=url + listaEstudioCinema.getId()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>