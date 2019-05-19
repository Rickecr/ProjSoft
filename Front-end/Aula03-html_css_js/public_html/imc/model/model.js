function calcular_imc(peso, altura) {
    return (peso / (altura ** 2));
}

function getStatus(imc) {
    let status = "";
    if (imc < 18.5) {
        status = "Abaixo do peso";
    } else if (imc >= 18.5 && imc <= 24.9) {
	    status = "Peso normal";
    } else if (imc >= 24.91 && imc <= 29.9) {
	    status = "Sobrepeso";
    } else if (imc >= 29.91 && imc <= 34.9) {
	    status = "Obesidade grau 1";
    } else if (imc >= 34.91 && imc <= 39.9) {
	    status = "Obesidade grau 2";
    } else if (imc >= 39.91) {
        status = "Obesidade grau 3";
    }
    return status;
}

export { calcular_imc, getStatus };