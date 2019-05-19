let mensagens = [];

// Variavel global.
window.render = render;

async function render() {
    mensagens.forEach(function (mensagem) {
        let html = 
        `
        <span>${ mensagem.mensagem }</span>
        <span>${ mensagem.autor }</span>
        <span>${ mensagem.at }</span>
        `;
        let li = document.createElement('li');
        li.innerHTML = html;
        
        let lstMsgs = document.getElementById('lstMsgs');
        lstMsgs.appendChild(li);
    })
}

async function get_mensagens() {
    let response = await fetch('mensagens.json');
    let dados = await response.json();
    mensagens = dados;
}

get_mensagens();