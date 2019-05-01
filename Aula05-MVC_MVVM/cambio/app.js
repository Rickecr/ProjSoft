import model from "./cambio.js";

function Real() {
    inpDolar.value = model.getDolar(inpReal.value);
    inpEuro.value = model.getEuro(inpReal.value);
}

function Dolar() {
    inpReal.value = model.getRealDolar(inpDolar.value);
    inpEuro.value = model.getEuro(inpReal.value);
}

function Euro(params) {
    inpReal.value = model.getRealEuro(inpEuro.value);
    inpDolar.value = model.getDolar(inpReal.value);
}

const inpReal = document.getElementById('inpReal');
inpReal.onkeyup = Real;

const inpDolar = document.getElementById('inpDolar');
inpDolar.onkeyup = Dolar;

const inpEuro = document.getElementById('inpEuro');
inpEuro.onkeyup = Euro;