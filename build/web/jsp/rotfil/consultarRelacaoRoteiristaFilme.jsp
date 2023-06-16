<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>CONSULTAR - ROTEIRISTA - FILME</title>
    <body>
       <div class="container"/>
       <h1>CONSULTAR ROTEIRISTA - FILME</h1>
       <form name="consultarRelacaoRoteiristaFilme" action="validaConsultarRelacaoRoteiristaFilme.jsp" method="post">
           Titulo do Roteiro: <input type="text" name ="TITULOROTEIRO" value=""> <br>
           <input type="submit" name ="Enviar" value="Enviar"> <br>
       </form>
       </div>
    </body>
</html>
