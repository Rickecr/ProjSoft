let mensagens = [];

async function getMensagens() {
    let response = await fetch('./mensagens.json');
    let dados = await response.json();
    mensagens = dados;
}

export { getMensagens, mensagens};