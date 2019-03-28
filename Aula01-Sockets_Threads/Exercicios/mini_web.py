import socket
import sys

s = socket.socket()

HOST = "localhost"
PORTA = int(sys.argv[1] if len(sys.argv) > 1 else 9090)

s.bind((HOST, PORTA))
s.listen()

conexao, cliente = s.accept()

headers = {}

def check_errors(verbo, recurso, protocolo):
    msg_erro = ""
    if (verbo != "GET"):
        msg_erro = "Error 405: Method Not Allowed"
    elif (recurso != "/"):
        msg_erro = "Error 404: Not Found"
    
    if (msg_erro != ""):
        return msg_erro
    else:
        return "200 OK"

def parse_request(msg):
    linhas = msg.split("\\n\\n")
    
    request_line = linhas[0].split("\\n")[0]
    headers_lines = linhas[0].split("\\n")
    headers_lines.pop(0)

    verbo = request_line.split()[0]
    recurso = request_line.split()[1]
    protocolo = request_line.split()[2]

    headers = {}

    for header in headers_lines:
        h = header.split(":")
        chave = h[0]
        valor = h[1]
        headers[chave] = valor
    
    result = check_errors(verbo, recurso, protocolo)
    corpo = ""
    response = "HTTP/1.1 " + result + "\n"
    if (result == "200 OK"):
        corpo = "Este é o conteúdo do recurso '/' neste servidor."
        response_header = "Content-type: text/html; charset=utf-8"
        response += corpo + "\n" + response_header

    return response


while True:
    msg = conexao.recv(4096)
    if (msg != ""):
        response = parse_request(msg.decode('utf-8'))
        conexao.sendall(response.encode('utf-8'))


