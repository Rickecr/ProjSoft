class PsPiadas extends HTMLElement {
    constructor() {
        super();
        this.$root = this.attachShadow({'mode': 'open'});
        this.piada = null;
    }

    async getPiadaAsync() {
        let response = await fetch("piadas.json");
        let piadas = await response.json();
        let pos = Math.floor(Math.random() * piadas.length);
        this.piada = piadas[pos];
    }

    getPiada() {
        return fetch('piadas.json').then(r => r.json()).then( piadas => {
            let pos = Math.floor(Math.random() * piadas.length);
            return piadas[pos];
        });
    }

    connectedCallback() {
        this.intervalo = this.getAttribute('intervalo');
        this.getPiada().then(piada => {
            this.piada = piada;
            this.$root.innerHTML = `${this.piada}`;
            this.render();
        });
    }

    render() {
        setInterval(() => {
            this.getPiada().then(piada => {
                this.piada = piada;
                this.$root.innerHTML = `${this.piada}`;
            });
        }, this.intervalo);
    }

}

customElements.define('ps-piadas', PsPiadas);