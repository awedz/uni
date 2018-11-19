import socket
from time import gmtime, strftime
from multiprocessing.pool import ThreadPool
import json

UDP_IP = "25.33.38.160"
UDP_PORT = 50055
pool = ThreadPool(processes=1)
s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
s.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
s.setsockopt(socket.SOL_SOCKET, socket.SO_BROADCAST, 1)
s.setblocking(False)
s.bind(('', UDP_PORT))

# json {method:'connect,disconect,msg',key:handshake,name:client name,msg:client msg}

def SendMessage(method,msg,ip,name,key):
    sndMsg = json.dumps({"method":method,"key":key,"name":name,"msg":msg})
    print(str(sndMsg))
    s.sendto(str.encode(str(sndMsg)), (ip, UDP_PORT))


def SendHandShake(method,ip,name):
    sndMsg = json.dumps({"method":method,"key":"","name":name,"msg":""})
    UDP_PORT = 50055
    s.sendto(str.encode(str(sndMsg)), (ip, UDP_PORT))


def SendDisconnect(method,key,name,ip):
    sndMsg = json.dumps(({"method":method,"key":key,"name":name,"msg":""}))
    UDP_PORT = 50055
    s.sendto(str.encode(str(sndMsg)), (ip, UDP_PORT))