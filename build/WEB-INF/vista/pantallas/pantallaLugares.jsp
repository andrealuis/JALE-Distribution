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


        <h1>que paso</h1>
                    <select id="pais" class="selectpicker" data-style="btn-info">
                        <option>Pais</option>
                    </select>
                    <select id="estado" class="selectpicker" data-style="btn-info" data-live-search="true">
                      <option>Estado</option>
                    </select>
                    <select id="municipio" class="selectpicker" data-style="btn-info" data-live-search="true">
                      <option>Municipio</option>
                    </select>
                   
             
                    <input type="submit" id="btn_NomAtrac" />
        
    </body>
</html>


