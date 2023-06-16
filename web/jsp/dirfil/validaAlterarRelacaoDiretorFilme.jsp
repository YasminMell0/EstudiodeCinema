<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="EstudioCinema.model.bean.DiretorFilme"%>
<%@page import="EstudioCinema.controller.ControllerDiretorFilme"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    int idD = Integer.parseInt(request.getParameter("ID_DIRETOR"));
    int idF = Integer.parseInt(request.getParameter("ID_FILME"));
    String cinematografia = request.getParameter("CINEMATOGRAFIA");
    String pbusca = request.getParameter("PBUSCA");
    DiretorFilme dirfil = new DiretorFilme(id,idD,idF,cinematografia);
    ControllerDiretorFilme dirfilcont = new ControllerDiretorFilme();
    dirfil = dirfilcont.alterar(dirfil);
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarRelacaoDiretorFilme.jsp?CINEMATOGRAFIA=" + pbusca;
    response.sendRedirect(url);
%>    
    
    