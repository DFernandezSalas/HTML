function validarFormulario(){
	//Obtener los valores del formulario
	var nombre = document.getElementById("nombre").value;
	var password = document.getElementById("password").value;
	var email = document.getElementById("email").value;
	var mensaje = document.getElementById("mensaje").value;
	
	if (nombre === "") {
		nombreError.innerHTML = "Ingrese un nombre valido.";
	} else{
		nombreError.innerHTML = "";
	}
	if (password === "") {
		passwordError.innerHTML = "Ingrese una contraseña.";
	}
	if (email === "") {
		emailError.innerHTML = "Ingrese un correo electronico vaido.";
	}
	if (mensaje === "") {
		mensajeError.innerHTML = "Ingrese un mensaje.";
	}
}