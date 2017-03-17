    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

    <c:forEach var="estado" items="${formaListadoEstados.estados}">
        <option value="${estado.idEstado}"><c:out value="${estado.nombreEstado}"/></option>
    </c:forEach>