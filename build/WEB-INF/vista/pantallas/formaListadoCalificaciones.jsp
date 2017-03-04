    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<c:forEach var="cal" items="${formaListadoCalificaciones.calificaciones}">
    <p><c:out value="${cal.comentario}"/></p>
    <p><c:out value="${cal.puntaje}"/></p>
</c:forEach>