<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="EstudioCinema.model.bean.Roteirista"%>
<%@page import="EstudioCinema.controller.ControllerRoteirista"%>

<%
    String nome = request.getParameter("NOME");
    String formacao = request.getParameter("FORMACAO");
    String qtdFilmes = request.getParameter("QTDFILMES");
    int idF = Integer.parseInt(request.getParameter("IDFILME"));
 
    Roteirista rot = new Roteirista(idF,nome,formacao,qtdFilmes);
    ControllerRoteirista rotcont = new ControllerRoteirista();
    rot = rotcont.inserir(rot);

    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "inserirRoteirista.jsp";
    response.sendRedirect(url);
%>

