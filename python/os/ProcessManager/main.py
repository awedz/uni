import psutil
import datetime
import txtParser
import processManager


# a = open("pocLog.txt", "a")
a = open("pocLog.txt", "a")
pids = processManager.GetInfo()
d = pids[1]
for i in d:
    print(i['pid'])
txtParser.WriteToFile(a, pids)
