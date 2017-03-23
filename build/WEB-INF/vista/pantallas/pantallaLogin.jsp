<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="css/login2.css">
  </head>
  <body>
    <br>
        

    <div class="col-xs-12 contLogin"> </div>

    <form id="forma" action="procesarLogin.dd" method="post">

      <div class="header">
        <div>ayuda<span>Turistica</span></div>
      </div>
      <br>
      <div class="login">
        <input type="text" 
               name="user" 
               size="50" 
               maxlength="100" 
<<<<<<< HEAD
               value="${formaLogin.user}" /><br>
=======
               value="${formaLogin.user}" 
               placeholder="Usuario"/><br>
>>>>>>> 409dbcf2de867aa1186e43ead17c4149d2681132
        <input type="password" 
               name="password" 
               size="50" 
               maxlength="100" 
<<<<<<< HEAD
               value="${formaLogin.password}" /><br>
=======
               value="${formaLogin.password}" 
               placeholder="Contrasena"/><br>
>>>>>>> 409dbcf2de867aa1186e43ead17c4149d2681132
        <input type="submit" 
               name="submit"
               value="Login"/>
        <input type="submit" 
               name="submit"
               value="Registrar" onclick="forma.action='solicitarRegistro.dd'"/>
      </div>
    </form>    
  </body>
</html>