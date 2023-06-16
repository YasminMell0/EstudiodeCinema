<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="EstudioCinema.model.bean.Usuario"%>
<%@page import="EstudioCinema.model.bean.Filme"%>
<%@page import="EstudioCinema.controller.ControllerFilme"%>
<%@page import="java.util.List"%>

<%
    String nome = request.getParameter("NOME");
    Filme fil = new Filme(nome);
    ControllerFilme filcont = new ControllerFilme();
    List<Filme> film = filcont.listar(fil);
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + nome+"&ID=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA FILME</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="Id">Id</th>
                  <th data-field="Nome">Nome</th>
                  <th data-field="Genero">Gênero</th>
                  <th data-field="TramaPrincipal">Trama Principal</th>
                  <th data-field="AnoLanc">Ano de Lançamento</th>
                  <th data-field="Desc">Descrição</th>
                  <th data-field="Excluir">Excluir</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(film.isEmpty())) { %>    
                <tbody>
                    <% for (Filme listaFilme : film) { %>
                        <tr>
                            <td><%=listaFilme.getId()%></td>
                            <td><%=listaFilme.getNome()%></td>
                            <td><%=listaFilme.getGenero()%></td>
                            <td><%=listaFilme.getTramaPrincipal()%></td>
                            <td><%=listaFilme.getAnoLanc()%></td>
                            <td><%=listaFilme.getDesc()%></td>
                            <% if (usuLogado.getTipo().equals("ADM")) { %>
                                <td><a href="excluirFilme.jsp?<%=url + listaFilme.getId()%>">Excluir</a></td>
                                <td><a href="alterarFilme.jsp?<%=url + listaFilme.getId()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>