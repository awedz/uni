import psutil


def GetProcessCount(processes):
    return sum([1 for prc in processes])


def GetAllProcesses():
    return [process.as_dict(attrs=['pid', 'name', 'username'])
            for process in psutil.process_iter()]


def GetInfo():
    currSash = GetAllProcesses()
    return [GetProcessCount(currSash), currSash]
