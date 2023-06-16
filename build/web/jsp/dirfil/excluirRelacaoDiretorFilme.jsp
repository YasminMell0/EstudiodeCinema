<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="EstudioCinema.model.bean.DiretorFilme"%>
<%@page import="EstudioCinema.controller.ControllerDiretorFilme"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    DiretorFilme dirFil = new DiretorFilme(id);
    ControllerDiretorFilme dirFilCont = new ControllerDiretorFilme();
    dirFil = dirFilCont.excluir(dirFil);
    
    String pbusca = request.getParameter("PBUSCA");
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarRelacaoDiretorFilme.jsp?CINEMATOGRAFIA=" + pbusca;
    response.sendRedirect(url);

%>

