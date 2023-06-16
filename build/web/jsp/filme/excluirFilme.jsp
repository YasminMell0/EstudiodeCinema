<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="EstudioCinema.model.bean.Filme"%>
<%@page import="EstudioCinema.controller.ControllerFilme"%>


<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Filme fil = new Filme(id);
    ControllerFilme filCont = new ControllerFilme();
    fil = filCont.excluir(fil);
    String pbusca = request.getParameter("PBUSCA");
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarFilme.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>