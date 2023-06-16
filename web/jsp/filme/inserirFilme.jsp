<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>INSERIR - FILME</title>
    <body>
       <div class="container"/>
        <h1>INSERIR FILME</h1>
        <form name="inserirFilme" action="validaInserirFilme.jsp" method="post">
            Nome: <input type="text" name="NOME" value=""> <br>
            Gênero <input type="text" name="GENERO" value=""> <br>
            Trama Principal: <input type="text" name="TRAMAPRINCIPAL" value=""> <br>
            Ano de Lançamento: <input type="text" name="ANOLANC" value=""> <br>
            Descrição: <input type="text" name="DESC" value=""> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        </div>
    </body>
</html>
