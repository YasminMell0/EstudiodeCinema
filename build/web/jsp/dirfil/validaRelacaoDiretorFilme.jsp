<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="EstudioCinema.model.bean.DiretorFilme"%>
<%@page import="EstudioCinema.controller.ControllerDiretorFilme"%>

<%
    int idD = Integer.parseInt(request.getParameter("ID_DIRETOR"));
    int idF = Integer.parseInt(request.getParameter("ID_FILME"));
    String cinematografia = request.getParameter("CINEMATOGRAFIA");
    DiretorFilme dirfil = new DiretorFilme(idD,idF,cinematografia);
    ControllerDiretorFilme dirfilcont = new ControllerDiretorFilme();
    dirfil = dirfilcont.inserir(dirfil);
    
// REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "inserirRelacaoDiretorFilme.jsp";
    response.sendRedirect(url);

%>