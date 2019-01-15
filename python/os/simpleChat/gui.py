# import the library
from appJar import gui
import json
import socket
from multiprocessing.pool import ThreadPool
import Network

UDP_IP = "25.16.197.160"
UDP_PORT = 50055
pool = ThreadPool(processes=1)
s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
s.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
s.setsockopt(socket.SOL_SOCKET, socket.SO_BROADCAST, 1)
s.setblocking(False)
s.bind(('', UDP_PORT))

myUser  = {}

# handle button events

# json {method:'connect,disconect,msg',key:handshake,name:client name,msg:client msg}

def OnTestClick(btn):
    pass
def OnConnect(btn):
    app.showSubWindow("connect")

def OnSendMessage(btn):
    msg = app.getEntry("message")
    Network.SendMessage("msg",msg,myUser["ip"],myUser["name"],myUser["key"])

#SendDisconnect(method,key,name,ip)
def onDisconnect():
    Network.SendDisconnect("dc",myUser["key"],myUser["name"],myUser["ip"])

def onQuit():
    onDisconnect()
    app.stop()

def SendHandShake(btn):
    Network.SendHandShake(btn,app.getEntry("ip"),app.getEntry("name"))
    app.hideSubWindow("connect")


def Listen():
    while True:
        try:
            message, address = s.recvfrom(8192)
            j = json.loads(message)
            if j["method"] == "connect":
                myUser["name"] = j["name"]
                myUser["ip"] = app.getEntry("ip")
                myUser["key"] = j["key"]
            elif j["method"] == "msg":
                app.setTextArea("t1",j["msg"],False,)
                app.setEntry("message","")
        except:
            pass


# create a GUI variable called app
app = gui("Login Window", "600x600")
app.setBg("orange")
app.setFont(18)

# add & configure widgets - widgets get a name, to help referencing them later
app.addLabel("title", "Welcome to appJar")
app.setLabelBg("title", "blue")
app.setLabelFg("title", "orange")
#------msgbox for msgs-------
app.addScrolledTextArea("t1")#main chat box

#-----buttons-------
app.addLabelEntry("message")
app.addButton("send",OnSendMessage)
#-----bar-----------
app.addMenuList("file",["connect","disconnect","quit"],[OnConnect,onDisconnect,onQuit])


#-----popups
#--login
app.startSubWindow("connect", modal=True)
app.setBg("orange")
app.setSize(400, 400)
app.addLabel("l1", "In sub window")
app.addLabelEntry("ip") 
app.addLabelEntry("name")
app.addButton("connect",SendHandShake)
app.stopSubWindow()



# link the buttons to the function called press
#app.addButtons(["Submit"], press)

app.setFocus("message")
pool.apply_async(Listen)

app.go()

