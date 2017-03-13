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
        <script>

            $(document).ready(function(){

                $("#select_option").change(function() {
                    var val = document.getElementById("selectPais").value;
                /*        var xhttp = new XMLHttpRequest();
                        xhttp.onreadystatechange = function() {
                        if(xhttp.status == 400){
                              
                        }
                        if (xhttp.readyState == 4 && xhttp.status == 200) {
                            document.getElementById("selectEstado").innerHTML = xhttp.responseText;
                        }
                        };
                    xhttp.open("GET", "solicitarListadoEstados.do?nombrePais="+val, true);
                    xhttp.send();*/
                alert("Hola "+ val);

                }
            });
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
        <form action="solicitarListarAtracciones.do" method="post">
            <select id="selectPais" class="selectpicker" data-style="btn-info" name = "pais">
                <c:forEach var="lugar" items="${formaListadoLugares.lugares}">
                    <option value="${lugar.pais}"><c:out value="${lugar.pais}"/></option>
                </c:forEach>
            </select>

            <select id="selectEstado" class="selectpicker" data-style="btn-info">
            </select>

            <select id="selectMunipio" class="selectpicker" data-style="btn-info">
            </select>       
                 
            <input type="submit" id="btn_NomAtrac" />
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

                
            </script>
        </form>
    </body>
</html>


