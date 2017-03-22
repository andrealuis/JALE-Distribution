<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>	



<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Document</title>
 <link rel="stylesheet" type="text/css" href="css/atracciones.css">
</head>
<body>
  <%
  Object obj = request.getParameter("atractionName");
%>

<html>
<head>
  <script src="http://maps.google.com/maps/api/js?sensor=false" type="text/javascript"></script>

  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBU1hQfkrec-V5nK7n7WJjAPzFAaTeyYcw">
    </script>
</head>
<body>

  
  <c:forEach var="atraccion" items="${formaAtraccion.atraccion}">
  <center>
    <c:if test="${(atraccion.id%2)==0}">
      <div class="col-xs-12 fondo" style="background-image:url('images/ImagenesAtracciones/${atraccion.path}.jpg')"> </div>
   </c:if>
   <c:if test="${(atraccion.id%2)!=0}">
    <div class="col-xs-12 col-md-6  imgAtrac">
      <img  width="355px;"  height="245px;"  src="images/ImagenesAtracciones/${atraccion.path}.jpg" ><br>
    </div>
  </c:if>

      <input type="hidden" id="nombreAtraccion" value="${atraccion.nombreAtraccion}">
      <input type="hidden" id="descripcionData" value="${atraccion.descripcion}">
      <input type="hidden" id="direccionData" value="${atraccion.direccion}">
    
  </center>
    
  </c:forEach>  
  <div class="col-xs-12 col-md-6 contenido">
    <h1 id="titulo"></h1>
     <h1 id="titulo"></h1>
    <h1 id="titulo"></h1>
    <h3>Descripcion del lugar</h3>
    <h4 id="descripcion"></h4>
    <h3>Direccion</h3>
    <h4 id="direccion"></h4>
    <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Ver Mapa</button>
    <a href="solicitarCalificacion.do?atractionName=<%=obj.toString()%>">Califica esta atraccion</a>
  </div>

  
  
   <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Modal Header</h4>
        </div>
        <div class="modal-body">
          <div id="map" style="height: 300px; width:400px;"></div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  


  
<script>
  	document.getElementById("titulo").innerHTML= document.getElementById("nombreAtraccion").value;
  	document.getElementById("descripcion").innerHTML = document.getElementById("descripcionData").value;
  	document.getElementById("direccion").innerHTML = document.getElementById("direccionData").value;

    var geocoder = new google.maps.Geocoder();
    var infowindow;
    var address = document.getElementById("direccionData").value;
    geocoder.geocode( { 'address': address}, function(results, status) {
      if (status == google.maps.GeocoderStatus.OK) {

        var latitude = results[0].geometry.location.lat();

        var  longitude = results[0].geometry.location.lng();

        var latLng = new google.maps.LatLng(latitude, longitude);
          var opciones = {
            center: latLng,
            zoom: 15,
            mapTypeId: google.maps.MapTypeId.ROADMAP
          };
          var map = new google.maps.Map(document.getElementById("map"), opciones);
          infowindow = new google.maps.InfoWindow();

        } 
    }); 
</script>
</body>
</html>