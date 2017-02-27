<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
<html>
    <head>
        <title>USJ</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <link rel="stylesheet" type="text/css" href="css/plantilla.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.7.5/css/bootstrap-select.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.11.2/js/bootstrap-select.min.js"></script>
    </head>
	
    <body>
        <table class="marco" cellpadding="0">
            <tr>
                <td colspan="2">
                    <c:import url="/WEB-INF/vista/comun/banner.jsp" />
                    <c:import url="/WEB-INF/vista/comun/barraMenu01.jsp" />
                </td>
            </tr>
            <tr height="590px">
                <td align="center" valign="center" width="100%">
                    <select class="selectpicker" data-style="btn-info">
                      <option>Pais</option>
                    </select>
                    <select class="selectpicker" data-style="btn-info" data-live-search="true">
                      <option>Estado</option>
                    </select>
                    <select class="selectpicker" data-style="btn-info" data-live-search="true">
                      <option>Municipio</option>
                    </select>
                    <select class="selectpicker" data-style="btn-info" data-live-search="true">
                      <option>Categoria</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <c:import url="/WEB-INF/vista/comun/barraPie.jsp" />
                </td>
            </tr>
        </table>
    </body>
</html>
