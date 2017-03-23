<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
<html>
    <head>
        <title>USJ</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
       	<link rel="stylesheet" type="text/css" href="css/bienvenido.css">
       	<script type="text/javascript" src="js/bienvenida.js"></script>
       	 <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
	
    <body>
      

<div class="intro">
  <div class="black"></div>  
  <div class="white"></div>
  <div class="boxfather">
    <div class="box">
      <h1>WELCOME </h1>
      <h1><c:out value="${formaLogin.user}"/></h1>
      <h1 id="time"></h1>
    </div>
  </div>
  
</div>

 <script>
      Reloj();
    function Reloj() {
          var tiempo = new Date();
          var hora = tiempo.getHours();
          var minuto = tiempo.getMinutes();
          setTimeout('Reloj()', 1000);
          str_hora = new String(hora);
          str_minuto = new String(minuto);
        
          if (str_hora.length == 1)
              document.getElementById('time').innerHTML = "0" + hora;
          else
              document.getElementById('time').innerHTML = hora;
          if(str_minuto.length == 1)
              document.getElementById('time').innerHTML += ":0"+minuto+ "hrs";
          else
              document.getElementById('time').innerHTML += ":"+minuto+ "hrs";
      }
    </script>
    </body>
</html>
