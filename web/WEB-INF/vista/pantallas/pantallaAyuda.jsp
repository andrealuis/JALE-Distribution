<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
<html>
    <head>
        <title>USJ</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <link rel="stylesheet" type="text/css" href="css/plantilla.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    
    <body>
       <div class="container marco">
        <!--CABEZERA-->
        <div class="row cabezera">
            <div class="col-xs-12 ">
                 <c:import url="/WEB-INF/vista/comun/banner.jsp" />
                 <c:import url="/WEB-INF/vista/comun/barraMenu01.jsp" />
            </div>
        </div>
        <!--FIN CABEZERA-->

        <!--PANTALLA-->
        <div class="row texto" >
            <div class="col-xs-12 ">
               

            <h1>holi esta es una prueba de responsive</h1>

            </div>
        </div>
        <!--FIN PANTALLA -->

        

        <!--Barra Pie-->
        <div class="row enlaces ">
            <div class="col-xs-12 col-md-6 redes">
               <c:import url="/WEB-INF/vista/comun/barraPie.jsp" />         
            </div>
        </div>
        <!--FIN Barra Pie-->
    </div>
    </body>
</html>