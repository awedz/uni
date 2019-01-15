import socket
import sys
import select
from multiprocessing.pool import ThreadPool

TIMEOUT = 1
UDP_IP = "25.33.38.163"
UDP_PORT = 5005
pool = ThreadPool(processes=1)
s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
s.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
s.setsockopt(socket.SOL_SOCKET, socket.SO_BROADCAST, 1)
s.setblocking(False)
s.bind(('', UDP_PORT))


def getLine():
    while 1:
        data = input()
        if data:
            return data


def SendMessage(message):
    s.sendto(str.encode(message), (UDP_IP, UDP_PORT))


def main():
    acync_res = pool.apply_async(getLine)
    while True:
        try:
            message, address = s.recvfrom(8192)
            if message:
                print(address, "> ", message)
        except:
            pass
        #input = acync_res.get()
        send = input()
        if(input != False):
            s.sendto(str.encode(send), (UDP_IP, UDP_PORT))


if __name__ == "__main__":
    main()
