<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="EstudioCinema.model.bean.RoteiristaFilme"%>
<%@page import="EstudioCinema.controller.ControllerRoteiristaFilme"%>

<%
    int idR = Integer.parseInt(request.getParameter("ID_ROTEIRISTA"));
    int idF = Integer.parseInt(request.getParameter("ID_FILME"));
    String tituloRoteiro = request.getParameter("TITULOROTEIRO");
    RoteiristaFilme rotfil = new RoteiristaFilme(idR,idF,tituloRoteiro);
    ControllerRoteiristaFilme rotfilcont = new ControllerRoteiristaFilme();
    rotfil = rotfilcont.inserir(rotfil);
    
// REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "inserirRelacaoRoteiristaFilme.jsp";
    response.sendRedirect(url);

%>