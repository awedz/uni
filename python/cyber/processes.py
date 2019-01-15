import os
import psutil
import inspect
import json


def CheckChanges(oldProc = [],newProc = []):
    keys = [oldProc[1]]#['pid', 'name', 'username','status','cpu_percent','path']
    print(keys)
    print(oldProc[0])
    print(newProc[0])
    aa = [i for i, j in zip(oldProc ,newProc) if i == j]
    # for (np,op) in zip(newProc,oldProc):
    #     curr = ''
    #     for key in keys:
    #         if op[key]!=np[key]:
    #             print('old: {0}, new: {1}'.format(op[key],np[key]),end='|')
    #     print('\n')
    #print(aa)
    pass

def ReadFile():
    readFile = {}
    procList = []
    with open("proc.txt") as f:
        for line in f:
            breakLines = line[:-1].split(', ') 
            for i in breakLines:
                (key,val) = i.split(': ')
                readFile.update({key:val})
            procList.append(readFile)
            readFile = {}
    return procList

def UpdateLog(file = {}):
    keys = [[*key][0] for key in file]
    #print([*file[0][keys[0]].keys()])
    innerKeys = [*file[0][keys[0]].keys()]
    #print([*[*line.values()][0].keys())
    index = 0
    aaa =[(k,ik) for k in keys for ik in innerKeys]
    for item in aaa:
        print(item[0],item[1])
    #procFile = open("proc.txt",'w')
    # for line in file:
    #     for key,Ikey in keys,innerKeys:
    #         print(line[key][Ikey])
        #st = "pid: {0}, name: {1}, username: {2}, status: {3}, cpu_percent: {4}, path: {5}\n".format(line.keys(),line[line.keys()]['name'],line['username'],line['status'],line['cpu_percent'],line['path'])
        #procFile.write(st)

def GetProcesses():
    proclist = []
    procDict = {}
    for proc in psutil.process_iter():
        try:
            pinfo = proc.as_dict(attrs=['pid', 'name', 'username','status','cpu_percent'])
        except psutil.NoSuchProcess:
            pass
        
        p = psutil.Process(pinfo["pid"])
        procDict.update({pinfo["pid"]:{'name': pinfo['name'], 'username': pinfo['username'], 'status': pinfo['status'], 'cpu_percent': pinfo['cpu_percent'], 'path' : p.exe() +'/'+p.name()}})
        proclist.append(procDict)
        procDict = {}
    return proclist

def main():
    currProc = GetProcesses()
    UpdateLog(currProc)
    oldProc = ReadFile()
    #CheckChanges(oldProc,currProc)
    #print("*"*20)
    #print(oldProc)
    pass

if __name__ == "__main__":
    main()