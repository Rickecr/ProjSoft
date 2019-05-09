import { calcular_imc, getStatus } from "../model/model.js";

function calculaImc() {
    var altura = document.getElementById('altura').value;
    var peso = document.getElementById('peso').value;

    var resultado = document.getElementById('resultado');
    var res = calcular_imc(peso, altura);
    resultado.innerText = "Resultado: " + res.toFixed(2);

    var status = getStatus(res);
    
    var stt = document.getElementById('status');
    stt.innerText = "Status: " + status;
}

document.getElementById("altura").onkeyup = calculaImc;
document.getElementById("peso").onkeyup = calculaImc;