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
        <script>
            Array.prototype.contains = function(v) {
                for(var i = 0; i < this.length; i++) {
                    if(this[i] === v) return true;
                }
                return false;
            };

            Array.prototype.unique = function() {
                var arr = [];
                for(var i = 0; i < this.length; i++) {
                    if(!arr.contains(this[i])) {
                        arr.push(this[i]);
                    }
                }
                return arr; 
            }
        </script>
    </head>	
    <body>
        <form id="form" method="post">
            <select id="selectPais" class="selectpicker" data-style="btn-info" name = "pais">
                <c:forEach var="lugar" items="${formaListadoLugares.lugares}">
                    <option value="${lugar.pais}"><c:out value="${lugar.pais}"/></option>
                </c:forEach>
            </select>

            <select id="selectEstado" class="selectpicker" data-style="btn-info">
            </select>

            <select id="selectMunipio" class="selectpicker" data-style="btn-info">
            </select>       
                 
            <button onclick="callAction()" id="btn_NomAtrac">Buscar</button>
            
        </form>
        <script>
            //Elimina valores repetidos en el pais 
            var sPais = document.getElementById("selectPais").options;
            var array= [];
            for (var i = 0; i < sPais.length; i++) {
                array[i] = sPais[i].value;
            }
            array = array.unique();
            var sPaisLen = sPais.length;
            for(i = 0; i < sPaisLen; i++){
                document.getElementById("selectPais").remove(0);
            }
            for(i = 0; i < array.length; i++){
                var option = document.createElement("option");
                option.text = array[i];
                document.getElementById("selectPais").add(option);
            }
            if(array.length == 1) //Si solo existe un pais manda a listar los estados inmediatamente
                getEstados();
            var selectPais = document.getElementById("selectPais"); //Instancia de selects
            var selectEstado = document.getElementById("selectEstado");

                //Funcion ajax para obtener los munipios
            function getMunicipios(){
                var val = document.getElementById("selectEstado").value; //Obtiene el valor del select
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function() {
                    if(xhttp.status == 400){}
                    if (xhttp.readyState == 4 && xhttp.status == 200) {
                        document.getElementById("selectMunipio").innerHTML = xhttp.responseText;
                    }
                };
                xhttp.open("GET", "solicitarListarMunicipios.do?nombreEstado="+val, true);
                xhttp.send();
            }

            //funcion ajax para obteer los estados
            function getEstados(){
                var val = document.getElementById("selectPais").value; //Obtiene el valor del select
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function() {
                    if(xhttp.status == 400){}
                    if (xhttp.readyState == 4 && xhttp.status == 200) {
                        document.getElementById("selectEstado").innerHTML = xhttp.responseText;
                    }
                };
                xhttp.open("GET", "solicitarListarEstados.do?nombrePais="+val, true);
                xhttp.send();
            }

            selectPais.addEventListener("change", function() {
                getEstados();
            });

            selectEstado.addEventListener("change", function() {
                getMunicipios();
            });

            function callAction(){
                //var val = document.getElementById("selectMunipio").value;
                //document.getElementById("form").action = "/solicitarAtraccion.do?atractionName="+val+".do";   
                document.getElementById("form").action = "/solicitarListarAtracciones.do";
            }
        </script>
    </body>
</html>


