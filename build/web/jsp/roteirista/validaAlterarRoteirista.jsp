<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="EstudioCinema.model.bean.Roteirista"%>
<%@page import="EstudioCinema.controller.ControllerRoteirista"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    String nome = request.getParameter("NOME");
    String formacao = request.getParameter("FORMACAO");
    String qtdFilmes = request.getParameter("QTDFILMES");
    int idF = Integer.parseInt(request.getParameter("IDFILME"));
    String pbusca = request.getParameter("PBUSCA");
    Roteirista rot = new Roteirista(id,idF,nome,formacao,qtdFilmes);
    ControllerRoteirista rotCont = new ControllerRoteirista();
    rot = rotCont.alterar(rot);
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarRoteirista.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>