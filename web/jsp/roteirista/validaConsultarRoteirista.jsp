<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="EstudioCinema.model.bean.Usuario"%>
<%@page import="EstudioCinema.model.bean.Roteirista"%>
<%@page import="EstudioCinema.controller.ControllerRoteirista"%>
<%@page import="java.util.List"%>

<%
    String nome = request.getParameter("NOME");
    Roteirista rot = new Roteirista(nome);
    ControllerRoteirista rotcont = new ControllerRoteirista();
    List<Roteirista> rote = rotcont.listar(rot);
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + nome+"&ID=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA ROTEIRISTA</title>
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
            <% if (!(rote.isEmpty())) { %>    
                <tbody>
                    <% for (Roteirista listaRoteirista : rote) { %>
                        <tr>
                            <td><%=listaRoteirista.getId()%></td>
                            <td><%=listaRoteirista.getNome()%></td>
                            <td><%=listaRoteirista.getFormacao()%></td>
                            <td><%=listaRoteirista.getQtdFilmes()%></td>
                            <td><%=listaRoteirista.getF().getNome()%></td>
                            <% if (usuLogado.getTipo().equals("ADM")) { %>
                                <td><a href="excluirRoteirista.jsp?<%=url + listaRoteirista.getId()%>">Excluir</a></td>
                                <td><a href="alterarRoteirista.jsp?<%=url + listaRoteirista.getId()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>