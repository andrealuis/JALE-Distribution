<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>	
<form id="forma" action="procesarAtraccion.do" method="post">
	<input type="text" name="nombreAtraccion">
	<input type="text" name="direccion">
	<input type="text" name="descripcion">
	<c:import url="/WEB-INF/vista/pantallas/pantallaLugares.jsp" />
</form>
<script>
	alert(document.getElementById("textoRandom").innerHTML);
</script>