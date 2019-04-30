function addMensagem() {
    let msg = document.getElementById('msg').value;
    let autor = document.getElementById('autor').value;
    console.log("msg: " + msg + "\nautor: " + autor);

    let payload = {"mensagem" : msg, "autor": autor, "at" : "20:22"}

    fetch("mensagens.json",
    {
        method: "POST",
        body: JSON.stringify( payload )
    });

    var data = new FormData();
    data.append( "json", JSON.stringify( payload ) );

    fetch("mensagens.json",
    {
        method: "POST",
        body: data
    })
    .then(function (res) {
        console.log(res);
    });
    
}