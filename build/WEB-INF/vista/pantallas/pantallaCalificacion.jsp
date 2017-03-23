<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<!DOCTYPE html>
<html>
    <head>
        <title>USJ</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="css/estrellas.css">
         <link rel="stylesheet" type="text/css" href="css/calificaciones.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
    </head>
    
    <body>           
        <%
            Object obj = request.getParameter("atractionName");
        %>
        <!--PANTALLA-->
        <div class="col-xs-12 fondo" style="background-image:url('https://unpedacitodetupropiopastel.files.wordpress.com/2014/08/descargar-pack-fondos-de-pantalla-personas-57.jpg')"> </div>
        <div id="divCalificaciones">             
            <form id="form" action="procesarCalificacion.do?atractionName=<%= obj.toString()%>" method="post"> 
             <center>
                 <h1 id="titNom"> <%= obj.toString()%> </h1>
                <br>Comentario:<textarea id="textComent" name="comentario" style="margin: 0px; width: 240px; height: 100px; resize: none;" required=""></textarea>
                <p class="clasificacion">
                    <input id="radio1" type="radio" name="puntaje" value="5" required><!--
                --> <label for="radio1">&#9733;</label><!--
                --> <input id="radio2" type="radio" name="puntaje" value="4"><!--
                --> <label for="radio2">&#9733;</label><!--
                --> <input id="radio3" type="radio" name="puntaje" value="3"><!--
                --> <label for="radio3">&#9733;</label><!--
                --> <input id="radio4" type="radio" name="puntaje" value="2"><!--
                --> <label for="radio4">&#9733;</label><!--
                --> <input id="radio5" type="radio" name="puntaje" value="1"><!--
                --> <label for="radio5">&#9733;</label>
                </p>
              
                <input type="hidden" name="nombreAtraccion" value="<%= obj.toString()%>" required="">
                <button type="submit" class="btnCal" name="submit" value="Calificar"/><span> Calificar</span></button><br><br>
                <a class="button" href="solicitarListadoCalificaciones.do?atractionName=<%= obj.toString()%>" class="HipervinculoAdmon">Ver calificaciones de otros usuarios...</a>
           </center>
            </form>
        </div>
        <!--FIN PANTALLA -->
       
    </body>
</html>