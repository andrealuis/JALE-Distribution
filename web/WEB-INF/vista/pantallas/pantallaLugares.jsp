<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
<html>
    <head>
        <title>USJ</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    </head>	
    <body>
        <form action="" method="post">
        
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
             
        <input type="submit" id="btn_NomAtrac" />
        
        </form>
    </body>
</html>


