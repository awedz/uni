import datetime


def WriteToFile(writer, pidList):
    now = datetime.datetime.now()
    writer.write(now.strftime("%Y-%m-%d %H:%M") + "\n")
    writer.write("process count "+str(pidList[0]) + "\n")
    for i in pidList[1]:
        writer.write(str(i))
        writer.write("\n")
