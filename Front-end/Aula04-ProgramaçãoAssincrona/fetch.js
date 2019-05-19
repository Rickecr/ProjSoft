let response = fetch('dados.json')
.then(r => r.json() )
.then(dados => fetch(dados.links[0]))
.then(links => links.json())
.then(d => console.log(d));