import sys
import os
playerX = "X"
playerO="O"
gridSize = 9
gameGrid = {1:"1",2:"2",3:"3",4:"4",5:"5",6:"6",7:"7",8:"8",9:"9"}

def PrintGrid():
    for i in range(1,len(gameGrid.keys())+1):
        if int(i %3) == 0:
            sys.stdout.write("|{}|\n".format(gameGrid[i]))
            if int(i %3) == 0 and i <9:
                for i in range(0,9):
                    sys.stdout.write("-")
                sys.stdout.write("\n")
        else:
            sys.stdout.write("|{}|".format(gameGrid[i]))


def IsWinner(currPlayer):
    if gameGrid[1] == gameGrid[2] and gameGrid[2] == gameGrid[3]:#diognal
        return True
    elif gameGrid[4] == gameGrid[5] and gameGrid[5] == gameGrid[6]:
        return True
    elif gameGrid[7] == gameGrid[8] and gameGrid[8] == gameGrid[9]:
        return True
    elif gameGrid[1] == gameGrid[4] and gameGrid[4] == gameGrid[7]:#horizontal
        return True
    elif gameGrid[2] == gameGrid[5] and gameGrid[5] == gameGrid[8]:
        return True
    elif gameGrid[3] == gameGrid[6] and gameGrid[6] == gameGrid[9]:
        return True
    elif gameGrid[1] == gameGrid[5] and gameGrid[5] == gameGrid[9]:
        return True
    elif gameGrid[3] == gameGrid[5] and gameGrid[5] == gameGrid[7]:
        return True
    else:
        return False

def MakeMove(index,player):
    while index > 9 or  gameGrid[index] == player or not str(gameGrid[index]).isdigit() :
        print("wrong Index")
        index = TakeMove()
    gameGrid[index] = player

def TakeMove():
    userInput = str(raw_input("Choose index for play "))
    while not userInput.isdigit() or (int(userInput) < 0 or int(userInput)>10):
        userInput = str(raw_input("Wrong Input "))
    return int(userInput)

def main():
    moves = 1
    isGame = moves < 10
    while isGame:
        PrintGrid()
        currPlayer = "O" if int(moves % 2) == 0 else "X"
        print("{} is now playing".format(currPlayer)) 
        move = TakeMove()
        MakeMove(move,currPlayer)
        moves+=1
        if moves > 9:
            print("no more moves")
            return
        if IsWinner(currPlayer):
            print("{} won the game".format(currPlayer))
            return
        os.system('clear')


if __name__ == "__main__":
    main()

