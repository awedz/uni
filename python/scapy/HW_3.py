from scapy.all import *

# rdpcap comes from scapy and loads in our pcap file
packets = rdpcap('CaptureFile.pcap')

#the first byte
pkt = packets[0]

print(type(packets ))
print(type(pkt))

print("The first byte: ", pkt[0], "\n")

#the len of the first packet
print("The packet len: ", len(pkt), "\n")


#max pkt size
#max([(ind,len(p)) for ind,p in enumerate(packets) if len(p) == max([len(p) for p in packets])])
#too slow
max_pkt_size = max([len(p) for p in packets])
max_ind_size = max([(ind,len(p)) for ind,p in enumerate(packets) if len(p) == max_pkt_size])
print(max_ind_size)

#min pkt size
min_pkt_size = min([len(p) for p in packets])
min_ind_size = min([(ind,len(p)) for ind,p in enumerate(packets) if len(p) == min_pkt_size])
print(min_ind_size)



google_cnt = 0
ynet_cnt = 0
Super_cnt = 0
hello_cnt = 0

for i in range(0, len(packets)):
    pkt = str(packets[i])
    google_cnt +=  pkt.count("google")
    ynet_cnt +=  pkt.count("ynet")
    Super_cnt +=  pkt.count("SuperPhramLogo.gif")
    hello_cnt +=  pkt.count("HelloWorld")
#print("google: {0}\nynet: {1}\nSuperPhramLogo.gif: {2}\nHelloWorld: {3}\n".format(google_cnt, ynet_cnt, Super_cnt, hello_cnt))

#print("The amount of packets", len(pkt), "\n")

a = ["\n".join(x.sprintf("{Raw:%Raw.load%}\n").split(r"\r\n")) for x in packets]
b = [x.split("\n") for x in a]
for p in b:
    if "GET" in p[0]:
        print(p[1])
