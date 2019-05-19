# IntroduÃ§Ã£o a Threads com Python

> Importante: Este cÃ³digo deve ser executado usando **Python 3**.

O script `contadores.py` permite criar mÃºltiplos contadores
regressivos que funcionam â€œsimultaneamenteâ€ e com intervalos
prÃ³prios. Para executar o script, digite:

```
$ python3 mthreads.py
```

## Comportamento esperado

Observe que dois contadores diferentes estarÃ£o em funcionamento.
Um nomeado `"5 Segundos"` conta de 5 abaixo a cada 1 segundo.  E
o segundo contador, nomeado simplesmente de `"A"` (para facilitar
a identificaÃ§Ã£o na saÃ­da do programa) contarÃ¡ regressivamente de
15 abaixo, mas em intervalos de 300ms.

O script `mthreads2.py` faz exatamente o mesmo, mas usa o estilo
baseado em classes ao invÃ©s de funÃ§Ãµes para criar as _threads_.

> SugestÃ£o: para entender melhor o funcionamento do cÃ³digo, mude
> os contadores criados.