<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>	



<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Document</title>
 <link rel="stylesheet" type="text/css" href="css/atracciones.css">
</head>
<body>
  <%
  Object obj = request.getParameter("atractionName");
%>

  <c:forEach var="atraccion" items="${formaAtraccion.atraccion}">
  <center>
    <c:if test="${atraccion.id==1}">
      <div class="col-xs-12 fondo" style="background-image:url('images/ImagenesAtracciones/${atraccion.path}.jpg')"> </div>
   </c:if>
   <c:if test="${atraccion.id!=1}">
    <div class="col-xs-12 col-md-6 abajo imgAtrac">
      <img  width="300px;"  height="200px;"  src="images/ImagenesAtracciones/${atraccion.path}.jpg" ><br>
    </div>
  </c:if>

      <input type="hidden" id="nombreAtraccion" value="${atraccion.nombreAtraccion}">
      <input type="hidden" id="descripcionData" value="${atraccion.descripcion}">
      <input type="hidden" id="direccionData" value="${atraccion.direccion}">
   
   
  </center>
    
  </c:forEach>  
  <div class="col-xs-12 col-md-6 contenido">
    <h1 id="titulo"></h1>
    <h3>Descripcion del lugar</h3>
    <h4 id="descripcion"></h4>
    <h3>Direccion</h3>
    <h4 id="direccion"></h4>

    <a href="solicitarCalificacion.do?atractionName=<%=obj.toString()%>">Califica esta atraccion</a>
  </div>
  
  
<script>
    document.getElementById("titulo").innerHTML= document.getElementById("nombreAtraccion").value;
    document.getElementById("descripcion").innerHTML = document.getElementById("descripcionData").value;
    document.getElementById("direccion").innerHTML = document.getElementById("direccionData").value;
</script>

</body>
</html>