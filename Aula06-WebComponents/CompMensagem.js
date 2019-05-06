class PsMensagem extends HTMLElement {
    constructor() {
        super();
        this.$shadowRoot = this.attachShadow({"mode": "open"});
    }

    connectedCallback() {
        this.mensagem = this.getAttribute('mensagem');
        this.autor = this.getAttribute('autor');
        this.at = this.getAttribute('at');
        this.render();
    }

    render() {
        let html = `
            <link rel="stylesheet" href="msg.css">
            <p class="mensagem">${this.mensagem}</p>
            <span class="autor">${this.autor}</span>
            <span class="at">${this.at}</span>
        `;
        this.$shadowRoot.innerHTML = html;
    }

}

customElements.define('ps-mensagem', PsMensagem);