import Model from '../model/model.js';

let model = new Model();

async function getModel() {
    await model.getApi();
}

getModel();

const inpDolar = document.getElementById('inpDolar');
const inpEuro = document.getElementById('inpEuro');
const inpReal = document.getElementById('inpReal');

inpReal.onkeyup = () => {
    let valorD = model.getRealParaDolar(inpReal.value);
    inpDolar.value = valorD;
    let valorE = model.getRealParaEuro(inpReal.value);
    inpEuro.value = valorE;
}

inpDolar.onkeyup = () => {
    let valorR = model.getDolarParaReal(inpDolar.value);
    inpReal.value = valorR;
    let valorE = model.getDolarParaEuro(inpDolar.value);
    inpEuro.value = valorE;
}

inpEuro.onkeyup = () => {
    let valorR = model.getEuroParaReal(inpEuro.value);
    inpReal.value = valorR;
    let valorE = model.getEuroParaDolar(inpEuro.value);
    inpDolar.value = valorE;
}