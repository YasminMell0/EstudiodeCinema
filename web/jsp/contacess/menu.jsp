<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="EstudioCinema.model.bean.Usuario"%>
<%@page import="EstudioCinema.controller.ControllerUsuario"%>

<%
    String login = request.getParameter("LOGIN");
    String senha = request.getParameter("SENHA");
    Usuario usuEntrada = new Usuario(login,senha);
    ControllerUsuario usucont = new ControllerUsuario();
    Usuario usuSaida = usucont.validarWeb(usuEntrada);
    session.setAttribute("UsuarioLogado",usuSaida);
%>


<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>SISTEMA </title>
    <body>
        <% if (usuSaida != null) { %>
            <!-- Dropdown1 Trigger -->     
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown1'>Manter Usuario</a><br><br>
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown2'>Manter Diretor</a><br><br>
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown3'>Manter Estudio de Cinema</a><br><br>  
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown4'>Manter Filme</a><br><br>
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown5'>Manter Roteirista</a><br><br>
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown6'>Manter Diretor-filmes</a><br><br>
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown7'>Manter Roteirista-filmes</a><br><br>    

            <% if (usuSaida.getTipo().equals("ADM")) { %>
                <!-- Dropdown1 Structure -->
                <ul id='dropdown1' class='dropdown-content'>
                    <li><a href="../usuario/inserirUsuario.jsp"> Inserir Usuario </a></li>
                    <li><a href="../usuario/consultarUsuario.jsp"> Consultar Usuario Parametro </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown1' class='dropdown-content'>
                    <li><a href="../usuario/consultarUsuario.jsp"> Consultar Usuario Parametro </a></li>
                </ul>
            <% } %>
            <% if (usuSaida.getTipo().equals("ADM")) { %>
                <!-- Dropdown2 Structure -->
                <ul id='dropdown2' class='dropdown-content'>
                    <li><a href="../diretor/inserirDiretor.jsp"> Inserir Diretor </a></li>
                    <li><a href="../diretor/consultarDiretor.jsp"> Consultar Diretor </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown2' class='dropdown-content'>
                    <li><a href="../diretor/consultarDiretor.jsp"> Consultar Diretor </a></li>
                </ul>
            <% } %>
            <% if (usuSaida.getTipo().equals("ADM")) { %>
                <!-- Dropdown3 Structure -->
                <ul id='dropdown3' class='dropdown-content'>
                    <li><a href="../estudioCinema/inserirEstudioCinema.jsp"> Inserir Estudio Cinema </a></li>
                    <li><a href="../estudioCinema/consultarEstudioCinema.jsp"> Consultar Estudio Cinema </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown3' class='dropdown-content'>
                    <li><a href="../estudioCinema/consultarRelacaoEstudioCinema.jsp"> Consultar Estudio Cinema </a></li>
                </ul>
            <% } %>
            <% if (usuSaida.getTipo().equals("ADM")) { %>
                <!-- Dropdown4 Structure -->
                <ul id='dropdown4' class='dropdown-content'>
                    <li><a href="../filme/inserirFilme.jsp"> Inserir Filme </a></li>
                    <li><a href="../filme/consultarFilme.jsp"> Consultar Filme </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown4' class='dropdown-content'>
                    <li><a href="../filme/consultarFilme.jsp"> Consultar Filme </a></li>
                </ul>
            <% } %>
            <% if (usuSaida.getTipo().equals("ADM")) { %>
                <!-- Dropdown5 Structure -->
                <ul id='dropdown5' class='dropdown-content'>
                    <li><a href="../roteirista/inserirRoteirista.jsp"> Inserir Roteirista </a></li>
                    <li><a href="../roteirista/consultarRoteirista.jsp"> Consultar Roteirista </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown5' class='dropdown-content'>
                    <li><a href="../roteirista/consultarRoteirista.jsp"> Consultar Roteirista </a></li>
                </ul>
            <% } %>
            <% if (usuSaida.getTipo().equals("ADM")) { %>
                <!-- Dropdown6 Structure -->
                <ul id='dropdown6' class='dropdown-content'>
                    <li><a href="../dirfil/inserirRelacaoDiretorFilme.jsp"> Inserir Diretor Filme </a></li>
                    <li><a href="../dirfil/consultarRelacaoDiretorFilme.jsp"> Consultar Diretor Filme </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown6' class='dropdown-content'>
                    <li><a href="../dirfil/consultarRelacaoDiretorFilme.jsp"> Consultar Diretor Filme </a></li>
                </ul>
            <% } %>
            <% if (usuSaida.getTipo().equals("ADM")) { %>
                <!-- Dropdown6 Structure -->
                <ul id='dropdown7' class='dropdown-content'>
                    <li><a href="../rotfil/inserirRelacaoRoteiristaFilme.jsp"> Inserir Roteirista Filme </a></li>
                    <li><a href="../rotfil/consultarRelacaoRoteiristaFilme.jsp"> Consultar Roteirista Filme </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown7' class='dropdown-content'>
                    <li><a href="../rotfil/consultarRelacaoRoteiristaFilme.jsp"> Consultar Roteirista Filme </a></li>
                </ul>
            <% } %>
            <% } else { %>
                <h1>USUÁRIO INVÁLIDO</h1>
        <% } %>
    </body>
</html>