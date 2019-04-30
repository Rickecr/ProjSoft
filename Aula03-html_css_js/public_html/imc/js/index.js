function calculaImc() {
    var altura = document.getElementById('$altura').value;
    var peso = document.getElementById('$peso').value;

    var resultado = document.getElementById('resultado');
    var res = (peso / (altura ** 2));
    resultado.innerText = "Resultado: " + res.toFixed(2);

    var status = "";
    if (res < 18.5) {
        status = "Abaixo do peso";
    } else if (res >= 18.5 && res <= 24.9) {
	status = "Peso normal";
    } else if (res >= 24.91 && res <= 29.9) {
	status = "Sobrepeso";
    } else if (res >= 29.91 && res <= 34.9) {
	status = "Obesidade grau 1";
    } else if (res >= 34.91 && res <= 39.9) {
	status = "Obesidade grau 2";
    } else if (res >= 39.91) {
	status = "Obesidade grau 3";						    }
    var stt = document.getElementById('status');
    stt.innerText = "Status: " + status;
}
