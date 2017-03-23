    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>


<html>
  <head>
    <link rel="stylesheet" type="text/css" href="css/registro.css">
  </head>
  <body>
    <div class="col-xs-12 contLogin"> </div>
    <form id="forma" action="procesarRegistro.dd" method="post">
      <div class="header">
        <div>hey<span>Regristrate</span></div>
      </div>
      <br>
      <div class="login">
        <input type="text" 
               name="prefijo" 
               size="12" 
               maxlength="12" 
               value="${formaNuevaPersona.prefijo}" 
               placeholder="Prefijo"/>
        <input type="text" 
               name="nombre" 
               size="50" 
               maxlength="100" 
               value="${formaNuevaPersona.nombre}" 
               placeholder="Nombre"/>
        <input type="text" 
               name="apellidoPaterno" 
               size="50" 
               maxlength="100" 
               value="${formaNuevaPersona.apellidoPaterno}" 
               placeholder="Apellido Paterno"/>
        <input type="text" 
               name="apellidoMaterno" 
               size="50" 
               maxlength="100" 
               value="${formaNuevaPersona.apellidoMaterno}" 
               placeholder="Apellido Materno"/>
        <input type="text" 
               name="nombreUsuario" 
               size="50" 
               maxlength="100" 
               value="${formaNuevaPersona.nombreUsuario}" 
               placeholder="Nombre Usuario"/>
        <input type="password" 
               name="claveAcceso" 
               size="50" 
               maxlength="100" 
               value="${formaNuevaPersona.claveAcceso}" 
               placeholder="Clave Acceso"/>
        <input type="password" 
               name="claveAccesoConfirmacion" 
               size="50" 
               maxlength="100" 
               value="${formaNuevaPersona.claveAccesoConfirmacion}" 
               placeholder="Clave Acceso Confirmacion"/>

        <input type="submit" 
               name="submit"
               value="Registrarse"/>                
        <input type="submit" 
               name="org.apache.struts.taglib.html.CANCEL" 
               value="Cancelar" 
               onclick="bCancel=true;">
      </div>
    </form>
  </body>
</html>

