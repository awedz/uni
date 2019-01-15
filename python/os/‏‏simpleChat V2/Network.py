import socket
from time import gmtime, strftime
from multiprocessing.pool import ThreadPool

UDP_IP = "25.33.38.163"
UDP_PORT = 5005
pool = ThreadPool(processes=1)
s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
s.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
s.setsockopt(socket.SOL_SOCKET, socket.SO_BROADCAST, 1)
s.setblocking(False)
s.bind(('', UDP_PORT))

def SendMessage():
    pass

def SendHandShake():
    pass

def SendDisconnect():
    pass
    
def Listen():
    pass


