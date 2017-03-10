<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>	
<meta charset="UTF-8">
<h1 id="titulo"></h1>
<table>
  <c:forEach var="atraccion" items="${formaAtraccion.atraccion}">
    <tr>
      <td><img src="images/ImagenesAtracciones/${atraccion.path}.jpg" width="80" height="70"></td>
    </tr>
    <tr>
    </tr>
    <input type="hidden" id="nombreAtraccion" value="${atraccion.nombreAtraccion}">
    <input type="hidden" id="descripcionData" value="${atraccion.descripcion}">
    <input type="hidden" id="direccionData" value="${atraccion.direccion}">
  </c:forEach>
</table>  
<h3>Descripción del lugar</h3>
<p id="descripcion"></p>
<h3>Dirección</h3>
<p id="direccion"></p>
<script>
  	document.getElementById("titulo").innerHTML= document.getElementById("nombreAtraccion").value;
  	document.getElementById("descripcion").innerHTML = document.getElementById("descripcionData").value;
  	document.getElementById("direccion").innerHTML = document.getElementById("direccionData").value;
</script>