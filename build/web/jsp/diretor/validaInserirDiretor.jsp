<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="EstudioCinema.model.bean.Diretor"%>
<%@page import="EstudioCinema.controller.ControllerDiretor"%>

<%
    String nome = request.getParameter("NOME");
    String formacao = request.getParameter("FORMACAO");
    String qtdFilmes = request.getParameter("QTDFILMES");
    int idF = Integer.parseInt(request.getParameter("IDFILME"));
 
    Diretor dir = new Diretor(idF,nome,formacao,qtdFilmes);
    ControllerDiretor dircont = new ControllerDiretor();
    dir = dircont.inserir(dir);

    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "inserirDiretor.jsp";
    response.sendRedirect(url);
%>

