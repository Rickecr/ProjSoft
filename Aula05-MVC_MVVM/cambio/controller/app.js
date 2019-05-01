let dados;

async function getModel() {
    let response = await fetch("./model/cambio.json");
    dados = await response.json();
    
    dados['getDolar'] = function getDolar(valorReal) {
        return valorReal * this.dolar;
    };
    dados['getEuro'] = function getDolar(valorReal) {
        return valorReal * this.euro;
    };
    dados['getRealDolar'] = function getRealDolar(valorDolar) {
        return valorDolar / this.dolar;
    };
    dados['getRealEuro'] = function getRealEuro(valorEuro) {
        return valorEuro / this.euro;
    };
}

function Real() {
    inpDolar.value = dados.getDolar(inpReal.value);
    inpEuro.value = dados.getEuro(inpReal.value);
}

function Dolar() {
    inpReal.value = dados.getRealDolar(inpDolar.value);
    inpEuro.value = dados.getEuro(inpReal.value);
}

function Euro(params) {
    inpReal.value = dados.getRealEuro(inpEuro.value);
    inpDolar.value = dados.getDolar(inpReal.value);
}

const inpReal = document.getElementById('inpReal');
inpReal.onkeyup = Real;

const inpDolar = document.getElementById('inpDolar');
inpDolar.onkeyup = Dolar;

const inpEuro = document.getElementById('inpEuro');
inpEuro.onkeyup = Euro;

getModel();