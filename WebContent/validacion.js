/*function validarPassword(){
	var clave1 = document.getElementsByName("clave1");
	var clave2 = document.getElementsByName("clave2");
	var xmlhttp;
	if(clave1 != clave2){
		alert("Sus contraseñas no coinciden por favor verifique");
		return false;
	}
	return true;
}*/


function limpiar() {
	var d = document.getElementById("fo");
	while (d.hasChildNodes())
	d.removeChild(d.firstChild);
	}

function loadXMLDoc(url,cfunc){
	if (window.XMLHttpRequest)
	{// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	}
	else
	{// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=cfunc;
	xmlhttp.open("GET",url,true);
	xmlhttp.send();
}
function mostrar(){
	loadXMLDoc("mostrar.jsp",function()
	{
	if (xmlhttp.readyState==4 && xmlhttp.status==200){
		document.getElementById("listar").innerHTML=xmlhttp.responseText;
	}
});
}
function log(){
	loadXMLDoc("log.txt",function()
	{
	if (xmlhttp.readyState==4 && xmlhttp.status==200){
		document.getElementById("fo").innerHTML=xmlhttp.responseText;
	}
});
}
function regLugar(){
	loadXMLDoc("regLugar.txt",function()
	{
	if (xmlhttp.readyState==4 && xmlhttp.status==200){
		document.getElementById("fo").innerHTML=xmlhttp.responseText;
	}
});
}
function eliLugar(){
	loadXMLDoc("eliLugar.txt",function()
	{
	if (xmlhttp.readyState==4 && xmlhttp.status==200){
		document.getElementById("fo").innerHTML=xmlhttp.responseText;
	}
});
}
function actLugar(){
	loadXMLDoc("actLugar.txt",function(){
	if (xmlhttp.readyState==4 && xmlhttp.status==200){
		document.getElementById("fo").innerHTML=xmlhttp.responseText;
	}
	});
}
function reg(){
	loadXMLDoc("registrar.jsp",function(){
	if (xmlhttp.readyState==4 && xmlhttp.status==200){
		document.getElementById("fo").innerHTML=xmlhttp.responseText;
	}
	});
}
function pornombre(){
	loadXMLDoc("pornombre.txt",function(){
	if (xmlhttp.readyState==4 && xmlhttp.status==200){
		document.getElementById("fo").innerHTML=xmlhttp.responseText;
	}
	});
}
function portipo(){
	loadXMLDoc("portipo.txt",function(){
	if (xmlhttp.readyState==4 && xmlhttp.status==200){
		document.getElementById("fo").innerHTML=xmlhttp.responseText;
	}
	});
	
}
function favoritos(){
	loadXMLDoc("favoritos.txt",function(){
	if (xmlhttp.readyState==4 && xmlhttp.status==200){
		document.getElementById("fo").innerHTML=xmlhttp.responseText;
	}
	});
}