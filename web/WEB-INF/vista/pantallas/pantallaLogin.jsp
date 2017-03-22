<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>
<!DOCTYPE html>
    <html lang="en">
    <head>
      <meta charset="UTF-8">
      <title>Document</title>
      <link rel="stylesheet" type="text/css" href="css/login2.css">
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
                           value="${formaLogin.user}" /><br>
        <input type="password" 
                           name="password" 
                           size="50" 
                           maxlength="100" 
                           value="${formaLogin.password}" /><br>
        <input type="submit" 
                           name="submit"
                           value="Login"/>
    </div>
    </form>
    
    
    </body>
    </html>