<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="EstudioCinema.model.bean.EstudioCinema"%>
<%@page import="EstudioCinema.controller.ControllerEstudioCinema"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    String nome = request.getParameter("NOME");
    String dataCriacao = request.getParameter("DATACRIACAO");
    int idF = Integer.parseInt(request.getParameter("IDF"));
    int idD = Integer.parseInt(request.getParameter("IDD"));
    int idR = Integer.parseInt(request.getParameter("IDR"));
    String pbusca = request.getParameter("PBUSCA");
    EstudioCinema est = new EstudioCinema(id,idF,idD,idR,nome,dataCriacao);
    ControllerEstudioCinema estCont = new ControllerEstudioCinema();
    est = estCont.alterar(est);
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarEstudioCinema.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>