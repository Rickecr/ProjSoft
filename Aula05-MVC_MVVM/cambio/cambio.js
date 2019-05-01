const model = {
    real: 1,
    dolar: 3.92,
    euro: 4.39,
    getDolar: function getDolar(valorReal) {
        return valorReal * this.dolar;
    },
    getEuro: function getDolar(valorReal) {
        return valorReal * this.euro;
    },
    getRealDolar: function getRealDolar(valorDolar) {
        return valorDolar / this.dolar;
    },
    getRealEuro: function getRealEuro(valorEuro) {
        return valorEuro / this.euro;
    }
}

export default model;