<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>	

<h1 id="titulo"></h1>
  <c:forEach var="atraccion" items="${formaAtraccion.atraccion}">
    <img src="images/ImagenesAtracciones/${atraccion.path}.jpg" width="280" height="270">
    <input type="hidden" id="nombreAtraccion" value="${atraccion.nombreAtraccion}">
    <input type="hidden" id="descripcionData" value="${atraccion.descripcion}">
    <input type="hidden" id="direccionData" value="${atraccion.direccion}">
  </c:forEach>

  <h3>Descripcion del lugar</h3>
  <h4 id="descripcion"></h4>
  <h3>Direccion</h3>
  <h4 id="direccion"></h4>
  
<script>
  	document.getElementById("titulo").innerHTML= document.getElementById("nombreAtraccion").value;
  	document.getElementById("descripcion").innerHTML = document.getElementById("descripcionData").value;
  	document.getElementById("direccion").innerHTML = document.getElementById("direccionData").value;
</script>