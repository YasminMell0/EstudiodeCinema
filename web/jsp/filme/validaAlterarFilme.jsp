<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="EstudioCinema.model.bean.Filme"%>
<%@page import="EstudioCinema.controller.ControllerFilme"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    String nome = request.getParameter("NOME");
    String genero = request.getParameter("GENERO");
    String tramaPrincipal = request.getParameter("TRAMAPRINCIPAL");
    String anoLanc = request.getParameter("ANOLANC");
    String desc = request.getParameter("DESC");
    String pbusca = request.getParameter("PBUSCA");
    Filme fil = new Filme(id,nome,genero,tramaPrincipal,anoLanc,desc);
    ControllerFilme filCont = new ControllerFilme();
    fil = filCont.alterar(fil);
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarFilme.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>