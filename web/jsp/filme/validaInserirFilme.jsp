<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="EstudioCinema.model.bean.Filme"%>
<%@page import="EstudioCinema.controller.ControllerFilme"%>

<%
    String nome = request.getParameter("NOME");
    String genero = request.getParameter("GENERO");
    String tramaPrincipal = request.getParameter("TRAMAPRINCIPAL");
    String anoLanc = request.getParameter("ANOLANC");
    String desc = request.getParameter("DESC");
 
    Filme fil = new Filme(nome,genero,tramaPrincipal,anoLanc,desc);
    ControllerFilme filcont = new ControllerFilme();
    fil = filcont.inserir(fil);

    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "inserirFilme.jsp";
    response.sendRedirect(url);
%>

