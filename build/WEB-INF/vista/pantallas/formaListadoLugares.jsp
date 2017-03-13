    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

    
        <select class="selectpicker" data-style="btn-info" name = "pais">
            <c:forEach var="lugar" items="${formaListadoLugares.lugares}">
                <option><c:out value="${lugar.pais}"/></option>
            </c:forEach>
        </select>

        <select class="selectpicker" data-style="btn-info">
            <c:forEach var="lugar" items="${formaListadoLugares.lugares}">
                <option><c:out value="${lugar.estado}"/></option>
            </c:forEach>
        </select>

        <select class="selectpicker" data-style="btn-info">
            <c:forEach var="lugar" items="${formaListadoLugares.lugares}">
                <option><c:out value="${lugar.nombre}"/></option>
            </c:forEach>
        </select>