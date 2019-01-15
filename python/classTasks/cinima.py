class Movie:
    def __init__(self,name,length):
        self.name = name
        self.length = length

class Hall:
    CONST_ROW_MAX = 'l'
    CONST_COL_MAX = 8

    def __init__(self):
        self.seats = {}
        for row in range(ord('a'),ord('l')):
            self.seats[chr(row)] = [' ' for col in range(0,8)]

    def BookSeats(self,row,col,tickets):
        for t in int(tickets):
            while row > Hall.CONST_ROW_MAX or int(col) > Hall.CONST_COL_MAX :
                #take input
                print('wrong Index')
            while self.seats[row][col] != ' ':
                #take input
                print('seat is taken')
            self.seats[row][col] ='X'
        


class Cinema:
    CONST_ROOM_SIZE = 6
    CONST_MOVIES = 100

    def __init__(self):
        self.halls = []
        self.movies = 0
        self.movieList = []

    def AddMovie(self,name,length):
        if len(self.movieList) < Cinema.CONST_MOVIES:
            self.movieList.append(Movie(name,length))
        pass
    def ScheduleMovie(self,name):
        if len(self.halls) < Cinema.CONST_MOVIES:
            self.halls.append({name:([Movie(i.name,i.length) for i in self.movieList if i.name == name],Hall())})

    
    def PrintHall(self,movieName):
        print('\t\t----screen----')
        print('    0    1    2    3    4    5    6    7 ')
        m = [i for i in self.halls if i[movieName][0][0].name == movieName ][0]
        ind =  self.movieList.index(m)
        print(m)
        for r in m:
            print(r)
            #print(r.values()[0][0][0].name)
        #     print('{0}'.format(r.values()[0][1].seats))
            print('{0}-{1}'.format(r,self.halls[hallnum].seats[r]))
        print('row:a-l col:0-7 movie:{0}'.format(self.movieList[0].name)) 



a = Cinema()
m = 'aaaa-The Movie'
a.AddMovie('aaaa-The Movie','120')
a.ScheduleMovie('aaaa-The Movie')
a.PrintHall(m)
# a.halls[0].BookSeats('a',1)
# a.halls[0].BookSeats('a',2)
# a.halls[0].BookSeats('b',2)
# a.PrintHall(0)
h = Hall()
