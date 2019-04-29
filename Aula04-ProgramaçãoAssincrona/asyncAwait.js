async function minhaFuncao() {
    let promise = new Promise((res, rej) => {
        setTimeout(() => res("OI"), 1000);
    });
    return promise;
}

function recebedor(msg) {
    console.log(msg);
}

async function main() {
    let response = await minhaFuncao();
    console.log(response);
}

main();