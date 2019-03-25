import socket
import sys
from threading import Thread

# Criação do socket.
s = socket.socket()

# Escolhendo porta e host.
PORTA = int(sys.argv[1] if len(sys.argv) > 1 else 8000 )
HOST = 'localhost'

# Conectando.
s.bind((HOST, PORTA))
s.listen()

conexoes = []

# Função que irá enviar a mensagem de um cliente para todos os clientes.
def enviaMensagem(msg, conexao, cliente):
    for con in conexoes:
        if (con != conexao):
            nome = "%s => " %cliente
            con.sendall(nome.encode('utf-8'))
            con.sendall(msg)

# Função que irá enviar a mensagem para todos os outros caso um cliente saia. 
def enviaMsgSaiu(cliente, con):
    msg_sair = "%s saiu da conversa\n" % cliente
    for conexao in conexoes:
            conexao.sendall(msg_sair.encode('utf-8'))

# Função que será chamada pela thread daquele cliente e que irá verificar se ele enviar uma mensagem.
def Cliente(cliente, conexao):
    while True:
        msg = conexao.recv(4096)
        if (msg == b':bye\n'):
            conexoes.remove(conexao)
            enviaMsgSaiu(cliente, conexao)
            conexao.close()
            break
        elif (msg != ""):
            enviaMensagem(msg, conexao, cliente)

# Função que iŕa ficar escutando novos clientes e criando suas threads.
def EscutaConexao():
    while True:
        conexao, cliente = s.accept()
        conexoes.append(conexao)

        conexao.sendall("Digite seu Nick: ".encode('utf-8'))
        nick = conexao.recv(4096)
        nick_name = nick.decode('utf-8').split("\n")[0]

        print("Cliente %s conectado" % nick_name)
        if (cliente):
            thread = Thread(target=Cliente, args=(nick_name, conexao)).start()

# Thread para escutar novas conexões de clientes.
Thread(target=EscutaConexao).start()

