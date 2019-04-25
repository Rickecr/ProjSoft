async function minhaFuncao() {
    let response = await fetch('dados.json');
    let dados = await response.json();
    let response1 = await fetch(dados.links[0]);
    let dados1 = await response1.json();
    return dados1;
}

async function main() {
    let teste = await minhaFuncao();
    console.log(teste);
}

main();