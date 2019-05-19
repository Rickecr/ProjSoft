import socket,sys, os

s = socket.socket()

HOST = "localhost"
PORT = int(sys.argv[1] if len(sys.argv) > 1 else 9090)

s.bind((HOST, PORT))
s.listen()

connetion, client = s.accept()

def searchArchive(name):
    archive = ""
    archives = os.listdir(".")
    for arq in archives:
        if (arq == name):
            archive = arq
            break

    return archive

def get_body_archive(name):
    response = "HTTP/1.1 "
    body = ""
    result = "200 OK"
    header = "Content-Type: text/html; charset=UTF-8\r\n"

    if (os.path.exists(name)):
        arq = searchArchive(name)
        archive = open(os.getcwd() + "/" + arq, 'r')
        for i in archive.readlines():
            body += i
        response = response + result + "\r\n" + header + "\r\n" + body + "\r\n"   
    else:
        result = "404 Not Found\r\n"
        response = response + result + header + "\r\n"
    
    return response

def check_errors(verbo, resource):
    msg = ""
    output = [True, msg]
    if (verbo != "GET"):
        output[1] = "405 Method Not Allowed"
        output[0] = False
    elif (resource[0] != "/"):
        output[1] = "404 Not Found"
        output[0] = False
    else:
        output[1] = "200 OK"

    return output

def get(resource, verbo):
    check = check_errors(verbo, resource)
    response = ""
    if (check[0]):
        if (len(resource) > 1):
            response = get_body_archive(resource[1:])
        else:
            body = "Este é o conteúdo do resource '/' neste servidor."
            response = "HTTP/1.1 200 OK\r\n"
            response_header = "Content-Type: text/html; charset=UTF-8\r\n"
            response += response_header + "\r\n" + body + "\r\n"
    else:
        response = "HTTP/1.1 " + check[1] + "\r\n"
    return response

def parse_request(msg):
    lines = msg.splitlines()
    request_line = lines[0].split("\\n")[0]
    headers_lines = lines[0].split("\\n")
    headers_lines.pop(0)

    verb = request_line.split()[0]
    resource = request_line.split()[1]
    protocol = request_line.split()[2]

    headers = {}
    response = ""
    
    for header in headers_lines:
        h = header.split(":")
        key = h[0]
        value = h[1]
        headers[key] = value
    
    response = get(resource, verb)

    return response


while True:
    msg = connetion.recv(4096)
    if (msg != b''):
        response = parse_request(msg.decode('utf-8'))
        connetion.sendall(response.encode('utf-8'))

'''
Testes:

Entrada:
    GET / HTTP/1.1\nHost: www.example.com\nConnection: close
output:
    HTTP/1.1 200 OK
    Content-Type: text/html; charset=UTF-8

    Este é o conteúdo do resource '/' neste servidor.
-----

Entrada:
    GET 1 HTTP/1.1\nHost: www.example.com\nConnection: close
output:
    HTTP/1.1 404 Not Found
-----

Entrada: 
    POST / HTTP/1.1\nHost: www.example.com\nConnection: close
output:
    HTTP/1.1 405 Method Not Allowed
-----

Entrada:
    GET /chat.py HTTP/1.1\nHost: www.example.com\nConnection: close
output:
    HTTP/1.1 200 OK
    Content-Type: text/html; charset=UTF-8

    import socket
    import sys ....
-----

Entrada:
    GET /nao_existe.py HTTP/1.1\nHost: www.example.com\nConnection: close
output:
    HTTP/1.1 404 Not Found
    Content-Type: text/html; charset=UTF-8
-----

'''