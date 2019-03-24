'''
# Cliente UDP.

import socket
HOST = '127.0.0.1'  # Endereco IP do Servidor
PORT = 5000            # Porta que o Servidor esta
udp = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
dest = (HOST, PORT)
print 'Para sair use CTRL+X\n'
msg = raw_input()
while msg != '':
    udp.sendto (msg, dest)
    msg = raw_input()
udp.close()

'''
# Cliente TCP.

import socket
HOST = '127.0.0.1'     # Endereco IP do Servidor
PORT = 5000            # Porta que o Servidor esta

tcp = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
dest = (HOST, PORT)
tcp.connect(dest)

msg = raw_input()
while msg != '':
    tcp.send(msg)
    msg = raw_input()

tcp.close()

'''
# Cliente TCP.
import socket

HOST = '127.0.0.1'  # The server's hostname or IP address
PORT = 5000        # The port used by the server

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.connect((HOST, PORT))
s.sendall(b'Hello, world')
data = s.recv(1024)

print('Received', repr(data))


'''