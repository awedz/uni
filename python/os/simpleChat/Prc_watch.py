import os
import ast
import psutil
import datetime
import time

curLog = "curLog.txt"
prevLog = "prevLog.tht"
sleepTime = 5

curProc = {}
prevProc = {}
def LogChanges():
    pass

def WriteToFile(fileName, pidList):
    now = datetime.datetime.now()
    if os.path.exists(fileName):
        os.remove(fileName)
    writer = open(fileName,'a')
    writer.write("---------- as of {} ---------\n".format(now.strftime("%Y-%m-%d %H:%M")))
    for i in pidList[1]:
        writer.write(str(i))
        writer.write("\n")

def GetAllProcesses():
    return [process.as_dict(attrs=['pid', 'name', 'username'])
            for process in psutil.process_iter()]

def CompChanges():
    prevLog = curProc
    curLog = GetAllProcesses()
    for proc in curProc:
        for field in proc:
            print(field)
    LogChanges()
# while True:
#     CompChanges()
#     time.sleep(5)



curLog = GetAllProcesses()



#a = GetAllProcesses()

#WriteToFile(curLog,GetAllProcesses())
#CompChanges()
#print(a)