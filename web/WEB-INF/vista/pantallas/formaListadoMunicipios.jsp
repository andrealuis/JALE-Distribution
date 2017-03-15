<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<c:forEach var="lugar" items="${formaListadoLugares.lugares}">
    <option><c:out value="${lugar.municipio}"/></option>
</c:forEach>