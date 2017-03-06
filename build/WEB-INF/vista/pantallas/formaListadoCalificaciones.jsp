<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>	
<%
	int var=0;
%>
<link rel="stylesheet" type="text/css" href="css/estrellas.css">
<table>
	<c:forEach var="cal" items="${formaListadoCalificaciones.calificaciones}">
	    <tr>
	    	<td><c:out value="${cal.comentario}"/></td>
	    </tr>
	    <tr>
	    	<td>
	    		<p class="clasificacion">	    			
                    <input id="radio<%= var%>5" type="radio" name="puntaje<%= var%>" value="5">
                	<label for="radio<%= var%>5">&#9733;</label>

                 	<input id="radio<%= var%>4" type="radio" name="puntaje<%= var%>" value="4">
                	<label for="radio<%= var%>4">&#9733;</label>

                	<input id="radio<%= var%>3" type="radio" name="puntaje<%= var%>" value="3">
                 	<label for="radio<%= var%>3">&#9733;</label>

                	<input id="radio<%= var%>2" type="radio" name="puntaje<%= var%>" value="2">
                 	<label for="radio<%= var%>2">&#9733;</label>

               		<input id="radio<%= var%>1" type="radio" name="puntaje<%= var%>" value="1">
                 	<label for="radio<%= var%>1">&#9733;</label>
                 	
                	<input type="hidden" id="puntajeValue" value="${cal.puntaje}">
                	<input type="hidden" id="loopValue" value="<%= var%>">
                	<%
						var++;
					%>
                	<script>
                		var puntaje = document.getElementById("puntajeValue");
                		var loop = document.getElementById("loopValue");
                		var puntajeVal = puntaje.value;
                		var loopVal = loop.value;

                		puntaje.remove();
                		loop.remove();
                		document.getElementById("radio"+loopVal+puntajeVal).checked = true;

                		var radios = document.getElementsByTagName("puntaje"+loop);
						for (var i=0;i<radios.length;i++) {
							radios[i].disabled = true;
						}

                	</script>
                </p> 
            </td>
	    </tr>
	</c:forEach>
</table>