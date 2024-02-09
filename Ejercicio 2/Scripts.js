function validarFormulario(){
	//Obtener los valores del formulario
	var nombre = document.getElementById("nombre").value;
	var password = document.getElementById("password").value;
	var email = document.getElementById("email").value;
	var mensaje = document.getElementById("mensaje").value;
	var nacimiento = document.getElementById("fechaNacimiento").value;
	var html = document.getElementById("html").checked;
	var css = document.getElementById("css").checked;
	var js = document.getElementById("js").checked;
	var terminos = document.getElementById("terminos").value;
	var archivo = document.getElementById("archivo").value;
	
	if (nombre === "") {
		nombreError.innerHTML = "Ingrese un nombre valido.";
	} else {
		nombreError.innerHTML = "";
	}
	if (password === "") {
		passwordError.innerHTML = "Ingrese una contraseña.";
	} else {
		passwordError.innerHTML = "";
	}
	if (email === "") {
		emailError.innerHTML = "Ingrese un correo electronico vaido.";
	}else{
		emailError.innerHTML = "";
	}
	if (mensaje === "") {
		mensajeError.innerHTML = "Ingrese un mensaje.";
	} else {
		mensajeError.innerHTML = "";
	}
	if (nacimiento === "") {
		nacimientoError.innerHTML = "Pon la fecha de tu nacimiento.";
	} else {
		nacimientoError.innerHTML = "";
	}
	if (!html && !css && !js){
		lenguajeError.innerHTML = "Elige una opcion.";
	} else {
		lenguajeError.innerHTML = "";
	} 
	if (!terminos.checked){
		terminosError.innerHTML = "Debes aceptar los terminos.";
	} else {
		terminosError.innerHTML = "";
	}
	if (archivo === ""){
		archivoError.innerHTML = "Debes subir un archivo."
	} else {
		archivoError.innerHTML = "";
	}
}