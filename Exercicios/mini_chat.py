import socket
import sys
from threading import Thread

s = socket.socket()


PORTA = int(sys.argv[1] if len(sys.argv) > 1 else 8000 )
HOST = 'localhost'

s.bind((HOST, PORTA))
s.listen()

conexoes = []

def Cliente(cliente, conexao):
    while True:
        msg = conexao.recv(4096)
        print(msg)
        if (msg == b':bye\n'):
            conexoes.remove(conexao)
            enviaMsgSaiu(cliente, conexao)
            conexao.close()
            break
        elif (msg != ""):
            for con in conexoes:
                if (con != conexao):
                    nome = "%s:%s => " %cliente
                    con.sendall(nome.encode('utf-8'))
                    con.sendall(msg)   

def enviaMsgSaiu(cliente, con):
    msg_sair = "%s:%s saiu da conversa\n" % cliente
    for conexao in conexoes:
            nome = "%s:%s => " %cliente
            conexao.sendall(msg_sair.encode('utf-8'))

def EscutaConexao():
    while True:
        conexao, cliente = s.accept()
        conexoes.append(conexao)

        print("Cliente %s:%s conectado" % cliente)
        if (cliente):
            thread = Thread(target=Cliente, args=(cliente, conexao)).start()

Thread(target=EscutaConexao).start()