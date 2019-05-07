# Aula sobre HTML, CSS e JavaScript.

A pasta `public_html` é o site hospedado no Apache no LCC3.

## Acessar o LCC3:

`ssh -p 23456 richecr@kirk.lcc.ufcg.edu.br`

### Mover arquivos da máquina local para o LCC3:

`scp -P 23456 -C /home/rickecr/~ richecr@kirk.lcc.ufcg.edu.br:/home/richecr/public_html/~`

### Mover pastas da máquina local para o LCC3:

`scp -r -P 23456 -C /home/rickecr/~ richecr@kirk.lcc.ufcg.edu.br:/home/richecr/public_html`

### Mover arquivos do LCC3 para a máquina local:

`scp -P 23456 -C richecr@kirk.lcc.ufcg.edu.br:/home/richecr/public_html/~ /home/rickecr/~`

### Mover pastas do LCC3 para a máquina local:

`scp -r -P 23456 -C richecr@kirk.lcc.ufcg.edu.br:/home/richecr/public_html/~ /home/rickecr/~`
