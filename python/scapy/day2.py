from scapy.all import *

a='8.8.8.8'
b=sr1(IP(dst=a)/ICMP())
b.show()