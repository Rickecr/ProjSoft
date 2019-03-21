from threading import Thread
import time

class Contador(Thread):
    def __init__(self, nome, segundos, intervalo):
        super(Contador, self).__init__()
        self.nome = nome
        self.segundos = segundos
        self.intervalo = intervalo

    def run(self):
        while self.segundos:
            print("%s: %s" % (self.nome, self.segundos))
            time.sleep(self.intervalo / 1000.0)
            self.segundos -= 1

print('Iniciando contador 1 ("5 Segundos")')
thread1 = Contador("5 Segundos", 5, 1000)

print('Iniciando contador 2 ("A")')
thread2 = Contador("A", 15, 300)

print("Iniciando thread1")
thread1.start()

# Fazendo a execução principal do programa esperar 5 segundos para só depois
# ir para próxima linha.
time.sleep(5)

print("Iniciando thread2")
thread2.start()

print('Fim')