<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="EstudioCinema.model.bean.EstudioCinema"%>
<%@page import="EstudioCinema.controller.ControllerEstudioCinema"%>


<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    EstudioCinema est = new EstudioCinema(id);
    ControllerEstudioCinema estCont = new ControllerEstudioCinema();
    est = estCont.excluir(est);
    String pbusca = request.getParameter("PBUSCA");
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarEstudioCinema.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>