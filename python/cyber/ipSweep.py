import subprocess
import ipaddress
import socket
import optparse
import multiprocessing.dummy
import re
from subprocess import Popen, PIPE
from termcolor import colored
from pyfiglet import Figlet

f = Figlet(font='small' )
reachableHost = []


def sweep( ip ):
    i = str(ip)
    toping = Popen(['ping', '-b','-c', '3', i], shell=False,stdout=PIPE)
    output = toping.communicate()[0]
    hostsalive = toping.returncode
    if hostsalive == 0:
        pid = Popen(["arp", "-n", i], stdout=PIPE)
        s = str(pid.communicate()[0])
        mac = re.search(r"(([a-f\d]{1,2}\:){5}[a-f\d]{1,2})", s).groups()[0] if not 'no entry' in s else 'cannot find MAC'
        print(colored(i + '   is reachable ' + 'MAC adress: ' + mac, 'cyan') )
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

def scanPorts(ip ,  isMenu=True):
    if not ip:
        ip=input("enter ip adress \n")
    print(colored("Checking for open ports on "+ ip + ".............",'red'))
    i = 0
    thredNum = 50
    pool = multiprocessing.dummy.Pool(thredNum)
    pool.map(portScan ,['{0},{1}'.format(ip,port) for port in range(1,10000)])
    if isMenu:
        printMenu()

def beginScan(ipScan, isMenu=True ):
    tempIp =  ipScan.split('.')
    ipScan='{0}.{1}.{2}'.format(tempIp[0],tempIp[1],tempIp[2])
    network = ipaddress.ip_network(ipScan+'.0/24')
    print(colored('ping sweep started on {0}.x ...............'.format(ipScan), 'red') )
    thredNum = 100
    pool = multiprocessing.dummy.Pool(thredNum)
    pool.map(sweep ,network)
    print("Found {} ip addresses".format(len(reachableHost)))
    if isMenu:
        printMenu()

def doAll( ip,isMenu=True ):
    beginScan(ip,False)
    for ip in reachableHost:
        scanPorts(ip, False)
    if isMenu:
        printMenu()

def ScanCurrentNetwork(isMenu=True):
    s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    s.connect(("8.8.8.8", 80))
    currIp=s.getsockname()[0]
    s.close()
    doAll(currIp)
    pass
choises = {
    0 : quit,
    1 : beginScan,
    2 : scanPorts,
    3 : doAll,
    4 : ScanCurrentNetwork

}

def printMenu( ):
    print (colored('|------------------------------------------|', 'cyan'))
    print (colored('|0.  exit                                  |', 'cyan'))
    print (colored('|1.  ping sweep                            |', 'cyan'))
    print (colored('|2.  port scan                             |', 'cyan'))
    print (colored('|3.  ping sweep and port scan to avl hosts |', 'cyan'))
    print (colored('|4.  Scan current network                  |', 'cyan'))
    print (colored('|------------------------------------------|', 'cyan'))
    choise = getUserChoise()
    if choise == '2' or choise ==  '1':
        choises[int(choise)](input("enter ip adress\nnetwork mask for expmle: 192.168.1.-\n"))
    else:
        choises[int(choise)]()

def getUserChoise():
        choise = ''
        while not str(choise).isdigit():
                choise = input("choose your option\n")
        return choise


def main():
    p = optparse.OptionParser()
    p.add_option('-s', help="start main menu")
    p.add_option('-x', help="start ping sweep")
    p.add_option('-p', help="start port scan")
    p.add_option('-a', help="start all")
    p.add_option('-c', help="start local scan")
    
    options, arguments = p.parse_args()
    if options.s == "start":
        print (f.renderText('Net Scan'))
        printMenu()
    elif options.x == "start":
        ip = arguments[0] or input("enter network mask for expmle: 192.168.1.-\n")
        print(ip+"----")
        choises[1](ip,False)
    elif options.p == "start":
        ip = input("enter ip adress\n")
        choises[2](ip, False)
    elif options.a:
        choises[3](ip,False)
    else:
        choises[4](False)
    printMenu()

main()