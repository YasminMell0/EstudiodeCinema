<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>INSERIR - ESTUDIO DE CINEMA</title>
    <body>
       <div class="container"/>
        <h1>INSERIR - ESTUDIO DE CINEMA</h1>
        <form name="inserirEstudioCinema" action="validaInserirEstudioCinema.jsp" method="post">
            Nome: <input type="text" name="NOME" value=""> <br>
            Data de Criação: <input type="text" name="DATACRIACAO" value=""> <br>
            ID do Filme: <input type="text" name="IDF" value=""> <br>
            ID do Diretor: <input type="text" name="IDD" value=""> <br>
            ID do Roteirista: <input type="text" name="IDR" value=""> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        </div>
    </body>
</html>
