from scapy.all import *
import re

data = rdpcap('CaptureFile.cap')
#1-------------------------------
hexD = [x.replace("\\","") for x in re.findall("\\\\x[0-9a-f][0-9a-f]",repr(str(data[0])))]
#a
#print("first byte is:",hexD[0])
#b
#print("byte len of packet is:",len(hexD))

#2------------------------------
google = 0
ynet = 0
slogo = 0
hw = 0

for pack in range(0,len(data)):
    aa = data[pack].getlayer(Raw)
    if aa != None:
        if re.findall("google",str(aa)):
            google+=1
        if re.findall("ynet",str(aa)):
            ynet+=1
        if re.findall("SuperPharmLogo.gif",str(aa)):
            slogo+=1
        if re.findall("HelloWorld",str(aa)):
            hw+=1
#print("google {0} ynet {1} slogo {2} hw {3}".format(google,ynet,slogo,hw))

#3-------------------------------
#print("packet count",len(data))

#4------------------------------
#longest = [(indx,len(pac)) for (indx,pac) in enumerate(data) if len(pac) == max([len(p) for p in data])]
#print(longest)

#5------------------------------
#shortest = [(indx,len(pac)) for (indx,pac) in enumerate(data) if len(pac) == min([len(p) for p in data])]
#print(shortest)

#6------------------------------

print([p for p in ["".join(re.findall(r'\\r\\nHost: (.*?)\\r\\n',str(pac))) for pac in data if pac.getlayer(Raw) != None] if len(p) > 0])
