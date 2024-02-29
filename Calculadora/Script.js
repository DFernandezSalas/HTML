var condicion = false;
var simbolo = true;
var suma = false;
var resta = false;
var multi = false;
var divi = false;
var resultado = 0;
var num1 = "";
var num2 = "";
var operador = "";

function cogerValor(a){
    
    if (condicion == false){
        if (num1 == "") {
            if (a == 1 || a == 2 || a == 3 || a == 4 || a == 5 || a == 6 || a == 7 || a == 8 || a == 9 ) {
                pantalla.innerHTML += a;
                num1 += a;
                simbolo = false;
            }
        } else {
            if (a == 1 || a == 2 || a == 3 || a == 4 || a == 5 || a == 6 || a == 7 || a == 8 || a == 9 || a == 0 ) {
                pantalla.innerHTML += a;
                num1 += a;
                simbolo = false;
            }
        }
    }
    if (simbolo == false) {
        if (a == '+' || a == '-' || a == '*' || a == '/'){
            pantalla.innerHTML += a;
            operador = a;
            simbolo = true;
            condicion = true;
        }
        if (operador == '+') {
            suma = true;
        } else if (operador == '-') {
            resta = true;
        } else if (operador == '*') {
            multi = true;
        } else if (operador == '/') {
            divi = true;
        }
    }
    if (condicion == true && simbolo == true){
        if (num2 == "") {
            if (a == 1 || a == 2 || a == 3 || a == 4 || a == 5 || a == 6 || a == 7 || a == 8 || a == 9 ) {
                pantalla.innerHTML += a;
                num2 += a;
            }
        } else {
            if (a == 1 || a == 2 || a == 3 || a == 4 || a == 5 || a == 6 || a == 7 || a == 8 || a == 9 || a == 0 ) {
                pantalla.innerHTML += a;
                num2 += a;
            }
        }
    }

    if (a == '=' && num1 != "" && num2 != "" && simbolo != ""){

        num1 = Number(num1);
        num2 = Number(num2);
        if (suma == true) {
            resultado = num1 + num2;
        } else if (resta == true) {
            resultado = num1 - num2;
        } else if (multi == true) {
            resultado = num1 * num2;
        } else if (divi == true) {
            resultado = num1 / num2;
        }

        pantalla.innerHTML = resultado;
        num1 = resultado;
        num2 = "";
        simbolo = false;
        suma = false;
        resta = false;
        multi = false;
        divi = false;
    }

    
}



function borrar() {
    pantalla.innerHTML = "";
    num1 = "";
    condicion = false;
    simbolo = true;
    suma = false;
    resta = false;
    multi = false;
    divi = false;
}