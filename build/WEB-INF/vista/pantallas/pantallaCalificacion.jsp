<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>



<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
<html>
    <head>
        <title>USJ</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="css/plantilla.css">
        <link rel="stylesheet" type="text/css" href="css/estrellas.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    
    <body>
     
        <c:import url="/WEB-INF/vista/comun/banner.jsp" />
        <c:import url="/WEB-INF/vista/comun/barraMenu01.jsp" />
      

        <!--PANTALLA-->
        <div class="row texto" width="500px">
            <div class="col-xs-12 ">
               

            <form id="form" action="procesarCalificacion.do" method="post">
                <textarea id="textComent" name="comentario" value="${formaNuevaCalificacion.comentario}"></textarea>
                <p class="clasificacion">
                <input id="radio1" type="radio" name="puntaje" value="5"><!--
                --><label for="radio1">&#9733;</label><!--
                --><input id="radio2" type="radio" name="puntaje" value="4"><!--
                --><label for="radio2">&#9733;</label><!--
                --><input id="radio3" type="radio" name="puntaje" value="3"><!--
                --><label for="radio3">&#9733;</label><!--
                --><input id="radio4" type="radio" name="puntaje" value="2"><!--
                --><label for="radio4">&#9733;</label><!--
                --><input id="radio5" type="radio" name="puntaje" value="1"><!--
                --><label for="radio5">&#9733;</label>
                </p>
                <input type="submit" name="submit" value="Calificar"/>

                <!--<a href="solicitarRegistroRol.do" class="HipervinculoAdmon">Ver calificaciones de otros usuarios...</a> -->
            </form>
            </div>
        </div>
        <!--FIN PANTALLA -->
        <footer>
            <c:import url="/WEB-INF/vista/comun/barraPie.jsp" />         
        </footer>
  
    </body>
</html>