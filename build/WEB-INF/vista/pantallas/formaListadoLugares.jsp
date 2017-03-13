    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

    <br>
    <font size='5'><fmt:message key="formaListadoLugares.titulo" /></font>
    <table cellpadding="0" cellspacing="0" width="60%" border="0">
        <tr>
            <td colspan="4">
               <html:errors />
            </td>
        </tr>
        
        <c:forEach var="lugar" items="${formaListadoLugares.lugares}">
          <tr>
            <td align="left" width="20%"><c:out value="${lugar.nombre}"/></td>
				    <td align="left" width="60%"><c:out value="${lugar.estado}"/></td>
            <td align="left" width="60%"><c:out value="${lugar.pais}"/></td>
          </tr>
        </c:forEach>
        <tr>
            <td colspan="4" align="right" style="padding-top:25px;"><b>Total:</b> ${formaListadoLugares.contador}</td>
        </tr>
    </table>