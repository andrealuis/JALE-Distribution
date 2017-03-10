<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
<html>
    <head>
        <title>Administrador de Roles - UPCHIAPAS</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <meta charset="UTF-8">
		<script type="text/javascript" src="js/Ajax.js"></script>
        <link rel="stylesheet" type="text/css" href="css/plantilla.css">
        <link rel="stylesheet" type="text/css" href="css/mensajes.css">
         <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
	
    <body>
      
            <c:import url="/WEB-INF/vista/comun/banner.jsp" />
            <c:import url="/WEB-INF/vista/comun/barraMenu01.jsp" />
             
            

            <div class="row texto" width="500px">
                <div class="col-xs-12 ">
                    <c:import url="/WEB-INF/vista/pantallas/${param.c}" />
                </div>
            </div>
           
            <c:import url="/WEB-INF/vista/comun/barraPie.jsp" />
              
        
    </body>
</html>
