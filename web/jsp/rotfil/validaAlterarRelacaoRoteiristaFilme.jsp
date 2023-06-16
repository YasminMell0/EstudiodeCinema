<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="EstudioCinema.model.bean.RoteiristaFilme"%>
<%@page import="EstudioCinema.controller.ControllerRoteiristaFilme"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    int idR = Integer.parseInt(request.getParameter("ID_ROTEIRISTA"));
    int idF = Integer.parseInt(request.getParameter("ID_FILME"));
    String tituloRoteiro = request.getParameter("TITULOROTEIRO");
    String pbusca = request.getParameter("PBUSCA");
    RoteiristaFilme rotfil = new RoteiristaFilme(id,idR,idF,tituloRoteiro);
    ControllerRoteiristaFilme rotfilcont = new ControllerRoteiristaFilme();
    rotfil = rotfilcont.alterar(rotfil);
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarRelacaoRoteiristaFilme.jsp?TITULOROTEIRO=" + pbusca;
    response.sendRedirect(url);
%>    
    
    