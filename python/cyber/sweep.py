import subprocess
import ipaddress
import socket
from termcolor import colored
from subprocess import Popen, PIPE
import re
import multiprocessing.dummy

host = socket.gethostbyname('scanme.nmap.org')
network = ipaddress.ip_network('192.168.1.0/24')
attempts = 1
reachableHost = []
sHost = host.split('.') 
def sweep( ip ):
    i = str(ip)
    toping = Popen(['ping', '-c', '3', i], shell=False,stdout=PIPE)
    output = toping.communicate()[0]
    hostsalive = toping.returncode
    if hostsalive == 0:
        pid = Popen(["arp", "-n", i], stdout=PIPE)
        s = str(pid.communicate()[0])
        mac = re.search(r"(([a-f\d]{1,2}\:){5}[a-f\d]{1,2})", s).groups()[0] if not 'no entry' in s else 'cannot find MAC'
        print(colored(i + ' is reachable ' + 'MAC adress: ' + mac, 'cyan') )
        reachableHost.append(i)

def portScan(args):
    port = int(args.split(',')[1])
    ip = args.split(',')[0]

    socket_tcp  = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
    socket_udp  = socket.socket(socket.AF_INET,socket.SOCK_DGRAM)
    socket.setdefaulttimeout(1)
    resuly_tcp = socket_tcp.connect_ex((ip,port))
    resuly_udp = socket_tcp.connect_ex((ip,port))
    socket_tcp.close()
    socket_udp.close()
    if not resuly_tcp:
        print('port: {0} is OPEN in ip {1} on TCP prtocol'.format(port,ip))
    if not resuly_udp:
        print('port: {0} is OPEN in ip {1} on UDP prtocol'.format(port,ip))
def scanPorts(ip):
    print(colored("Checking for open ports on "+ ip + ".............",'red'))
    i = 0
    thredNum = 50
    pool = multiprocessing.dummy.Pool(thredNum)
    pool.map(portScan ,['{0},{1}'.format(ip,port) for port in range(1,10000)])

def beginScan():
    print(colored('ping sweep started...............', 'red') )
    thredNum = 100
    pool = multiprocessing.dummy.Pool(thredNum)
    pool.map(sweep ,[host])

beginScan()
for ip in reachableHost:
    scanPorts(ip)