<%@page import="Negocio.gestion.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%if(session.getAttribute("persona") == null){%>
<jsp:forward page="index.jsp"></jsp:forward>
<%} %>
<%
Persona persona= (Persona)session.getAttribute("persona");
String tipo=persona.getTipo();
if(session.getAttribute("persona")!=null && tipo.equalsIgnoreCase("usuario")){ %>
	<jsp:forward page="usuario.jsp"></jsp:forward>
	

	<%} %>
<!DOCTYPE html>
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>East Sites</title>
<link rel="stylesheet" type="text/css" href="estilo.css">
<script type="text/javascript" src="validacion.js" ></script>
</head>
<body class = "cuerpo">
<div id="salir">
<form method="post" action="enlace">    
    <input type="submit" name="ok" value="Salir" class="button salir">
</form>
</div>


<section id="ban2">
<div><h1>Bienvenido</h1>
<p style="color:black;">Desde aqui puedes gestionar tus lugares. Registra tu local en la aplicacion para que los usuarios puedan conocerlo.
</br>Actualiza los datos de tu lugar siempre que sea necesario, tener informacion correcta evita malos entendidos.
</p></div>
<div id="propbuttons">
<button class="button login" id="enter" onclick="limpiar();regLugar();initialize();">Registrar Lugar</button>

<form method="post" action="/Jacam/PropietarioControl">
<input  type="submit" name="ok" value="consultarlugares" class="button login">
</form>
<br><b><a style="color:#D65417"><%= request.getParameter("msg")!=null?request.getParameter("msg"):""%></a></b>
</div>


<% 


%>

</section>

<!-- Main -->

<section id="main" class="container">

<section class="box special">

<div>
<p style="color:orange;">Descrubre las coordenadas de tu local posicionando el marcador en el lugar que se encuentra.
</br>
</p></div>
<div id="fo" class="inline"></div>
<div id="map"></div>

</section>

</section>
<script type="text/javascript">
function validarLatLon(){
	var lat = document.getElementById("markerLat").value;
	var longi = document.getElementById("markerLon").value;
	if(lat==0||longi==0){
		alert("Recuerde identificar con el marcador las coordenadas del lugar en el mapa")
		return false;
	}
	return true;
}
</script>
<script type="text/javascript">
	var map = null;
	var infoWindow = null;
	function openInfoWindow(marker) {
		var markerLatLng = marker.getPosition();
		infoWindow.setContent(
			"La posicion del marcador es: "+'</br>'+"Latitud: "+markerLatLng.lat()+" Longitud: "+markerLatLng.lng()+'</br>'+"Haz click en el marcador para actualizar"
		);
		infoWindow.open(map, marker);
		document.getElementById("markerLat").value=markerLatLng.lat();
		document.getElementById("markerLon").value=markerLatLng.lng();
	}

	function initialize() {
		var myLatlng = new google.maps.LatLng(6.148699, -75.356351);
		var myOptions = {
		  zoom: 13,
		  center: myLatlng,
		  mapTypeId: google.maps.MapTypeId.ROADMAP
		}

		map = new google.maps.Map(document.getElementById("map"), myOptions);

		infoWindow = new google.maps.InfoWindow();

		var marker = new google.maps.Marker({
		    position: myLatlng,
		    draggable: true,
		    map: map,
		    title:"Ejemplo marcador arrastrable"
		});

		google.maps.event.addListener(marker, 'click', function(){
			openInfoWindow(marker);
		});
	}
	       
    </script>
    <script async defer
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBRHzn9G_iNQggnEwwM_m7QCZiAH0C7S8U&libraries=places">
    </script>
	<script>
		function goBack() {
			window.history.back();
		}
	</script>
</body>
</html>