class PsPiadas extends HTMLElement {
    constructor() {
        super();
        this.$root = this.attachShadow({mode: 'open'});
        this.piada = null;
        this.intervalo = 0;
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

    async connectedCallback() {
        this.intervalo = this.getAttribute('intervalo');
        this.getPiada().then(piada => {
            this.piada = piada;
            this.$root.innerHTML = `${this.piada}`;
            console.log(this.piada);
        });

        this.atualiza();
    }

    atualiza() {
        this.atualizar = setInterval(() => {
            this.getPiada().then(piada => {
                this.piada = piada;
                this.$root.innerHTML = `${this.piada}`;
                console.log(this.piada);
            });
        }, this.intervalo);
    }

    static get observedAttributes() {
        return ['intervalo'];
    }

    attributeChangedCallback(name, oldValue, newValue) {
        if (oldValue !== null) {
            this.intervalo = newValue;
            clearInterval(this.atualizar);
            this.atualiza();
        }
    }
}

customElements.define('ps-piadas', PsPiadas);