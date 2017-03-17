<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>
<%@ page import ="java.util.ArrayList" %>
<%@ page import ="java.util.List" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
<html>
    <head>
        <title>USJ</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    </head>	
    <body>
        <form id="form" method="post">
            <select id="selectPais" class="selectpicker" data-style="btn-info" name = "pais">
                <c:forEach var="pais" items="${formaListadoPaises.paises}">
                    <option><c:out value="${pais.nombrePais}"/></option>
                    <input type="hidden" id="${pais.nombrePais}" value="${pais.idPais}"/>
                </c:forEach>
            </select>

            <select id="selectEstado" class="selectpicker" data-style="btn-info">
                <option>Selecciona un Estado</option>
            </select>

            <select id="selectMunicipio" class="selectpicker" data-style="btn-info">
                <option>Selecciona un Municipio</option>
            </select>       
                 
            <button onclick="callAction()" id="btn_NomAtrac">Buscar</button>
            
        </form>
        <script>
            var selectPais = document.getElementById("selectPais"); //Instancia de selects
            var selectEstado = document.getElementById("selectEstado");
            if(selectPais.length == 1) //Si solo existe un pais manda a listar los estados inmediatamente
                getEstados();
            //Funcion ajax para obtener los munipios
            function getMunicipios(){
                var val = document.getElementById("selectEstado").value;
                if(val!="Selecciona un Estado"){
                    var xhttp = new XMLHttpRequest();
                    xhttp.onreadystatechange = function() {
                        if(xhttp.status == 400){}
                        if (xhttp.readyState == 4 && xhttp.status == 200) {
                            document.getElementById("selectMunicipio").innerHTML = "<option>Selecciona un Municipio</option>"+ xhttp.responseText;
                        }
                    };
                    xhttp.open("GET", "solicitarListarMunicipios.do?idEstado="+val, true);
                    xhttp.send();
                }else{
                    alert("Selecciona un estado");  
                }
            }

            //funcion ajax para obteer los estados
            function getEstados(){
                var sValue = document.getElementById("selectPais").value; //Obtiene el valor del select
                var val = document.getElementById(sValue).value;
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function() {
                    if(xhttp.status == 400){}
                    if (xhttp.readyState == 4 && xhttp.status == 200) {
                        document.getElementById("selectEstado").innerHTML = "<option>Selecciona un Estado</option>"+xhttp.responseText;
                    }
                };
                xhttp.open("GET", "solicitarListarEstados.do?idPais="+val, true);
                xhttp.send();
            }

            selectPais.addEventListener("change", function() {
                getEstados();
            });

            selectEstado.addEventListener("change", function() {
                getMunicipios();
            });

            function callAction(){
                var idMunicipio = document.getElementById("selectMunicipio").value;
                document.getElementById("form").action = "/solicitarListarAtracciones.do?idMunicipio="+idMunicipio;
            }
        </script>
    </body>
</html>


