<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%if(session.getAttribute("persona") == null){%>
<jsp:forward page="index.jsp"></jsp:forward>
<%} %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:f="http://java.sun.com/jsf/core"      
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:p="http://primefaces.org/ui">
<head>	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="estilo.css">
<title>Insert title here</title>
</head>
<body class="cuerpo">
<section id="ban">
<h1>Es hora de cambiar tu contraseņa!!! </h1></br>


<div id="fo" >
	<form method="post" action="/Jacam/enlace" onsubmit="return comprobarClave()">
		<div class="divtext">
			Contraseņa:</br>
			<input type="password" id="clave1" name="clave1" class="textbox" placeholder="Contraseņa" pattern=".{4,}" title="Cuatro o mas Caracteres" maxlength="30" required></br>
			</div>
			Repeitir Contraseņa: </br>
			<div class="divtext">
			<input type="password" id="clave2" name="clave2" class="textbox" placeholder="Confirmar Contraseņa" maxlength="30" required></br>
			</div>
			<div id="errorClave"  style="color:#FF0000;"></div>
			<div class="bsub">
			<input type="submit" name="ok"  value="Cambiar" class="button login sub">
		</div>
	</form>
	

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
	      //alert("Las contraseņas no coinciden");
	      document.getElementById("errorClave").innerHTML="Las contraseņas no coinciden";
	      correcto=false;
      	}
    return correcto;
}

</script>


</body>

</html>