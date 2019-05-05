class Model {
    constructor() {
    }

    async getApi() {
        let response = await fetch('./api/api.json');
        this.api = await response.json();
    }

    teste() {
        return this.api;
    }

    getRealParaDolar(valorReal) {
        let valorD = this.api['real']['dolar'] * valorReal;

        return valorD;
    }

    getRealParaEuro(valorReal) {
        let valorE = this.api['real']['euro'] * valorReal;
        
        return valorE;
    }

    getDolarParaReal(valorDolar) {
        let valorR = this.api['dolar']['real'] * valorDolar;
        
        return valorR;
    }

    getDolarParaEuro(valorDolar) {
        let valorE = this.api['dolar']['euro'] * valorDolar;

        return valorE;
    }

    getEuroParaDolar(valorEuro) {
        let valorD = this.api['euro']['dolar'] * valorEuro;

        return valorD;
    }

    getEuroParaReal(valorEuro) {
        let valorR = this.api['euro']['real'] * valorEuro;
        
        return valorR;
    }
}

export default Model;