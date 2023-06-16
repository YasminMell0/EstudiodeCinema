<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>CONSULTAR - DIRETOR - FILME</title>
    <body>
       <div class="container"/>
       <h1>CONSULTAR DIRETOR - FILME</h1>
       <form name="consultarRelacaoDiretorFilme" action="validaConsultarRelacaoDiretorFilme.jsp" method="post">
           Cinematografia: <input type="text" name ="CINEMATOGRAFIA" value=""> <br>
           <input type="submit" name ="Enviar" value="Enviar"> <br>
       </form>
       </div>
    </body>
</html>
