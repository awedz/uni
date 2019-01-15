# import the library
from appJar import gui
import socket
from time import gmtime, strftime
from multiprocessing.pool import ThreadPool


# create a GUI variable called app
app = gui("chat", "600x600")
app.setBg("orange")
app.setFont(18)








# add & configure widgets - widgets get a name, to help referencing them later
app.addLabel("title", "Welcome to appJar")
app.setLabelBg("title", "blue")
app.setLabelFg("title", "orange")
app.addScrolledTextArea("Text")

app.addLabelEntry("message")
app.addLabelEntry("Port")
app.addLabelEntry("Ip")

app.setFocus("message")
# start the GUI
app.go()

