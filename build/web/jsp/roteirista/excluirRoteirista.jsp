<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="EstudioCinema.model.bean.Roteirista"%>
<%@page import="EstudioCinema.controller.ControllerRoteirista"%>


<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Roteirista rot = new Roteirista(id);
    ControllerRoteirista rotCont = new ControllerRoteirista();
    rot = rotCont.excluir(rot);
    String pbusca = request.getParameter("PBUSCA");
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarRoteirista.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>