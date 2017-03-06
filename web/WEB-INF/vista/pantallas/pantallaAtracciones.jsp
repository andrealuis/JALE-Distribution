<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<!DOCTYPE html>
<html>
    <head>
        <title>USJ</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script type="text/javascript" src="js/imgchan.js"></script>
    </head>
    
    <body>
        <div>
          <div class="imgen">
            <center>
              <img src="#" id="mifoto" class="image-preview " />
            </center>
          </div>
          <div class="imgen2">
            <center>
              <div class="file-input">
                <p>+</p>
                <input width="145" height="60" type="file" name="file" value="" id="file" accept="image/*;capture=camera" class="image-upload">
              </div>
            </center>
          </div>
          
        </div>
                
            
        
        <a href="solicitarCalificacion.do?atractionName=cafecafe">Pantalla calificacion</a>
    </body>
</html>