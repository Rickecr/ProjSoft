import { getMensagens, mensagens } from "./mensagens.js";

function render() {
    let $msg = document.getElementById('listMsg');

    mensagens.map((mensagem) => {
        let $html = `
            <p>${mensagem.mensagem}</p>
            <span>${mensagem.autor}</span>
            <span>${mensagem.at}</span>
        `;

        let $div = document.createElement('div');
        $div.innerHTML = $html;

        $msg.appendChild($div);
    });
}

getMensagens().then(function () {
    render();
});