<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>
<h1> Top Recomendaciones </h1>
<c:forEach var="recomendacion" items="${formaRecomendaciones.recomendaciones}">
	<p> <!--<c:out value="${recomendacion.nombrePais}"/> -->
		<h2><c:out value="${recomendacion.nombreEstado}"/></h2><br>
		<h3><c:out value="${recomendacion.nombreMunicipio}"/></h3>
		<h3><c:out value="${recomendacion.nombreAtraccion}"/></h3>
		<input id="radio1" type="radio" name="puntaje" value="5" required>
        <label for="radio1">&#9733;</label>
        <input id="radio2" type="radio" name="puntaje" value="4">
        <label for="radio2">&#9733;</label>
        <input id="radio3" type="radio" name="puntaje" value="3">
       	<label for="radio3">&#9733;</label>
        <input id="radio4" type="radio" name="puntaje" value="2">
        <label for="radio4">&#9733;</label>
        <input id="radio5" type="radio" name="puntaje" value="1">
        <label for="radio5">&#9733;</label>
		<input type="hidden" value="${recomendacion.puntaje}"/>
	</p>
</c:forEach>