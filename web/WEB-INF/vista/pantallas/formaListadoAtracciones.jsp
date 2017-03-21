    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

        <c:forEach var="atraccion" items="${formaListadoAtracciones.atracciones}">
	        	<br>
	        	<a href="solicitarAtraccion.do?atractionName= ${atraccion.nombreAtraccion}"><c:out value="${atraccion.nombreAtraccion}"/></a>   				
        </c:forEach>