function minhaFuncao(msg, tempo) {
    let promise = new Promise((res, rej) => {
        if (msg.length > 3) {
            setTimeout(() => res("oiiiiii"), tempo);
        } else {
            setTimeout(() => rej("String deve possuir mais de 3 caracteres"), tempo);
        }
    });
    return promise;
}

function recebedor(msg) {
    console.log(msg);
}

// Promise falha, entrando no catch.
let response = minhaFuncao("Oii", 2000)
.then((r) => console.log(r.toUpperCase()))
.catch((err) => {
    console.log("Erro: " + err);
});

// Promise conclui com sucesso.
let response1 = minhaFuncao("Oiii", 1000)
.then((r) => console.log(r.toUpperCase()))
.catch((err) => {
    console.log("Erro: " + err);
});



/*
Promise.resolve(1)
.then((r) => console.log(r));
*/