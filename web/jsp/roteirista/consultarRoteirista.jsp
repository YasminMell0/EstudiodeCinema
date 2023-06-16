<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>CONSULTAR - ROTEIRISTA</title>
    <body>
       <div class="container"/>
       <h1>CONSULTAR ROTEIRISTA</h1>
       <form name="consultarRoteirista" action="validaConsultarRoteirista.jsp" method="post">
           NOME <input type="text" name ="NOME" value=""> <br>
           <input type="submit" name ="Enviar" value="Enviar"> <br>
       </form>
       </div>
    </body>
</html>
