<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="EstudioCinema.model.bean.Diretor"%>
<%@page import="EstudioCinema.controller.ControllerDiretor"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    String nome = request.getParameter("NOME");
    String formacao = request.getParameter("FORMACAO");
    String qtdFilmes = request.getParameter("QTDFILMES");
    int idF = Integer.parseInt(request.getParameter("IDFILME"));
    String pbusca = request.getParameter("PBUSCA");
    Diretor dir = new Diretor(id,idF,nome,formacao,qtdFilmes);
    ControllerDiretor dirCont = new ControllerDiretor();
    dir = dirCont.alterar(dir);
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarDiretor.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>