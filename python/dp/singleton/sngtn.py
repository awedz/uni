class Singleton:
    __myList = []
    def GetInstance(self):
        return self.__myList
    def Insert(self,data):
        if self.__myList is None:
            self.__myList = []
        self.__myList.append(data)

a1 = Singleton()
a1.Insert( 1 )

a2 = Singleton()
a2.Insert( 2 )

print( a1.GetInstance() )


