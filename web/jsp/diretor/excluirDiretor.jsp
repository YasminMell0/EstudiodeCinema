<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="EstudioCinema.model.bean.Diretor"%>
<%@page import="EstudioCinema.controller.ControllerDiretor"%>


<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Diretor dir = new Diretor(id);
    ControllerDiretor dirCont = new ControllerDiretor();
    dir = dirCont.excluir(dir);
    String pbusca = request.getParameter("PBUSCA");
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarDiretor.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>