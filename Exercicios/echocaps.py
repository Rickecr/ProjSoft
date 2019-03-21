import socket
import sys

porta = int(sys.argv[1] if len(sys.argv) > 1 else 9090 )

s = socket.socket()

s.bind(('localhost', porta))
s.listen()
print('Conectado na porta: %s' % porta)

print('Aguardando conexão do cliente...')
conexao, cliente = s.accept()

print('Conectado com o cliente: %s:%s' % cliente)

# print(socket.gethostbyname(socket.gethostname()))

while True:
    print('Aguardando mensagem...')
    msg = conexao.recv(4096)
    print('Mensagem: %s' % msg)
    
    if not msg:
        break
    conexao.sendall(msg.upper())
