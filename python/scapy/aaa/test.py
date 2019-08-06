from scapy.all import *

#1 check TCP window field value
a = TCP()
#print(a.window)

#2 change TCP window defult value
a.window = 123
#print(a.window)

#3+4 UDP packet 
b = IP(ttl=128)/UDP(sport=666,dport=666)
#b.show()#sport and dport is doom

#5 input dst and ping 4 times(echo request)
#pingr = IP(dst="1.1.1.1")/ICMP()
#resp = srloop(pingr,count=4)
#print(resp)

#6+7 sniff x-times from user input
inp = 10
sniffer = sniff(inp)
#sniffer.summary()#6
#sniffer[0].show()#7 print n packet info

#8
pingr2 = IP(dst="1.1.1.1")/ICMP()
ans,unans = srloop(pingr2,count=4)
ans.summary()
print("\n")


asd = IP(dst="1.1.1.1",src="1.1.1.1")/ICMP()
asd.show()
print("\n")
ls(asd)
print("\n")
asd.summary()
