<%@page import="Negocio.gestion.*" %>
<%Persona persona= (Persona)session.getAttribute("persona");
if(session.getAttribute("persona") != null ){
	String tipo=persona.getTipo();
	if (tipo.equalsIgnoreCase("usuario")){%>
<jsp:forward page="usuario.jsp"></jsp:forward>
<%} if(tipo.equalsIgnoreCase("propietario")){%>
<jsp:forward page="propietario.jsp"></jsp:forward>
<%}} %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>East Sites</title>
<link rel="stylesheet" type="text/css" href="estilo.css">
<script type="text/javascript" src="validacion.js" ></script>
<%
	String error1= (String) (request.getAttribute("error1"));
	String error2= (String) (request.getAttribute("error2"));
	System.out.println("index -error1: "+error1);
	System.out.println("index -error2: "+error2);
	
%>
</head>
<body class="cuerpo">
<section id="ban">
<h1>East Sites </h1></br>

<button class="button login" id="login" onclick="limpiar();log()">Entrar</button> 
<button class="button enter" id="enter" onclick="limpiar();reg()">Registrarse</button> 

<div id="fo" >
	<br><b><a style="color:#D65417"><%= request.getParameter("msg")!=null?request.getParameter("msg"):""%></a></b>
	<input type="hidden" id="error1" value=<%= error1 %>>
	<input type="hidden" id="error2" value=<%= error2 %>></div>
	
<div id="errors">
	
</div>



</section>

<!-- Main -->

<section id="main" class="container">

<section class="box special">

<header class="major">

<h2>Be Happy.

<br />

Descubre nuevos sitios.</h2>

<p>Encuentra tus lugares de interes desde el movil.</p>

</header>

</section>

</section>
<script type="text/javascript">
function comprobarClave(){ 
	
   	var clave1 = document.getElementById("clave1").value;
   	var clave2 = document.getElementById("clave2").value;
	var correcto;
   	if (clave1 == clave2){
       correcto= true;
   	}
   	else{ 
	      //alert("Las contraseñas no coinciden");
	      document.getElementById("errorClave").innerHTML="Las contraseñas no coinciden";
	      correcto=false;
      	}
    return correcto;
}

</script>


</body>

</html>