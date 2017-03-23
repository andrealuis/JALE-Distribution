<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<%
	int var=0;
%>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/estrellas.css">
	<link rel="stylesheet" type="text/css" href="css/atracciones.css">
	<link rel="stylesheet" type="text/css" href="css/recomendacion.css">
</head>
<body>
<div class="col-xs-12 cont"> </div>
<div class="container-fluid">
		<div class="row">
<div class="col-xs-9 block text-center">
<c:forEach var="recomendacion" items="${formaRecomendaciones.recomendaciones}">
	<center>
	  			
			<h2><c:out value="${recomendacion.nombreMunicipio}, ${recomendacion.nombreEstado}"/></h2>
			<h2><a href="solicitarAtraccion.do?atractionName=${recomendacion.nombreAtraccion}"><c:out value="${recomendacion.nombreAtraccion}"/></a></h2>
		<!--	<div class="col-xs-12 col-md-6 abajo imgAtrac">-->
		    <img width="300px;"  height="200px;"  src="images/ImagenesAtracciones/${recomendacion.path}.jpg" ><br>
		    <!--</div>-->
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
	         	<label for="radio<%= var%>1">&#9733;</label><br>
	        </p>
	    	<input type="hidden" id="puntajeValue" value="${recomendacion.puntaje}">
	    	<input type="hidden" id="loopValue" value="<%= var%>">
	    	<h4><a href="solicitarListadoCalificaciones.do?atractionName=${recomendacion.nombreAtraccion}">Ver todas las opiniones de esta atraccion</a></h4>
		    
	
	</center>
	
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

		document.getElementById("radio"+loopVal+"1").disabled = true;
        document.getElementById("radio"+loopVal+"2").disabled = true;
        document.getElementById("radio"+loopVal+"3").disabled = true;
        document.getElementById("radio"+loopVal+"4").disabled = true;
        document.getElementById("radio"+loopVal+"5").disabled = true;
		
	</script>
</c:forEach>
</div>
</div>
</div>
</body>
</html>