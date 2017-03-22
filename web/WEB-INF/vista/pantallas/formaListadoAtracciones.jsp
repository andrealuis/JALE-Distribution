    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<link rel="stylesheet" type="text/css" href="css/listarAtrac.css">
</head>
<body>
<c:forEach var="atraccion" items="${formaListadoAtracciones.atracciones}">
	<div class= "col-xs-12 tabAtrac">
	    <table class="table table-bordered table-hover">
		    <thead>
		        <tr>
		        	<th>Nombre de la Atraccion</th>
		            <th>Ver mas</th>
		        </tr>
		    </thead>
		    <tbody>
		        <tr>
		            <td>
		            	<h1><c:out value="${atraccion.nombreAtraccion}"/> </h1>
		            	
		            </td>
		            <td>
		            	<center>
		            		<a class="button" href="solicitarAtraccion.do?atractionName=${atraccion.nombreAtraccion}">Ir</a>
		            	</center>
		            </td>
		        </tr>
		       
		    </tbody>
		</table>
	</div> 				
</c:forEach>
</body>
</html>


        