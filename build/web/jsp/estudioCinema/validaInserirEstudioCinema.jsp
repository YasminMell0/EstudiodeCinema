<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="EstudioCinema.model.bean.EstudioCinema"%>
<%@page import="EstudioCinema.controller.ControllerEstudioCinema"%>

<%
    String nome = request.getParameter("NOME");
    String dataCriacao = request.getParameter("DATACRIACAO");
    int idF = Integer.parseInt(request.getParameter("IDF"));
    int idD = Integer.parseInt(request.getParameter("IDD"));
    int idR = Integer.parseInt(request.getParameter("IDR"));
 
    EstudioCinema est = new EstudioCinema(idF,idD,idR,nome,dataCriacao);
    ControllerEstudioCinema estcont = new ControllerEstudioCinema();
    est = estcont.inserir(est);

    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "inserirEstudioCinema.jsp";
    response.sendRedirect(url);
%>

