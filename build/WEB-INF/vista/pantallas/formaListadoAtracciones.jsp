    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

        
        <c:forEach var="atraccion" items="${formaListadoAtracciones.atracciones}">
        	<c:if test="${atraccion.idMunicipio == 1}">
	        	<br>
	        	<a href=""><c:out value="${atraccion.nombreAtraccion}"/></a>   				
			</c:if>
        </c:forEach>