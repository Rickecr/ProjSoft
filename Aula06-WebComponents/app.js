import { getMensagens, mensagens } from "./mensagens.js";

function render() {
    let $msg = document.getElementById('listMsg');

    mensagens.map((mensagem) => {
        let $html = `
            <ps-mensagem mensagem="${mensagem.mensagem}" autor="${mensagem.autor}" at="${mensagem.at}">
            </ps-mensagem>
        `;

        let $div = document.createElement('div');
        $div.innerHTML = $html;

        $msg.appendChild($div);
    });
}

getMensagens().then(function () {
    render();
});