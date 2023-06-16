<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="EstudioCinema.model.bean.RoteiristaFilme"%>
<%@page import="EstudioCinema.controller.ControllerRoteiristaFilme"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    RoteiristaFilme rotFil = new RoteiristaFilme(id);
    ControllerRoteiristaFilme rotFilCont = new ControllerRoteiristaFilme();
    rotFil = rotFilCont.excluir(rotFil);
    
    String pbusca = request.getParameter("PBUSCA");
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarRelacaoRoteiristaFilme.jsp?TITULOROTEIRO=" + pbusca;
    response.sendRedirect(url);

%>

