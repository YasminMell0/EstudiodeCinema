<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>INSERIR - DIRETOR</title>
    <body>
       <div class="container"/>
        <h1>INSERIR DIRETOR</h1>
        <form name="inserirDiretor" action="validaInserirDiretor.jsp" method="post">
            Nome: <input type="text" name="NOME" value=""> <br>
            Formação: <input type="text" name="FORMACAO" value=""> <br>
            Quantidade de Filmes: <input type="text" name="QTDFILMES" value=""> <br>
            ID do Filme: <input type="text" name="IDFILME" value=""> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        </div>
    </body>
</html>
