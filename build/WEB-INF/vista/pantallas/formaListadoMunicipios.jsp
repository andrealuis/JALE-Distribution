<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<c:forEach var="municipio" items="${formaListadoMunicipios.municipios}">
    <option value="${municipio.idMunicipio}"><c:out value="${municipio.nombreMunicipio}"/></option>
</c:forEach>


