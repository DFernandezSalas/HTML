function cogerValor(a){
    pantalla.innerHTML += a;
}

function resultado() {
    var resultado = eval(document.getElementById("pantalla").innerHTML);
    pantalla.innerHTML = resultado;
}

function borrar() {
    pantalla.innerHTML = "";
}