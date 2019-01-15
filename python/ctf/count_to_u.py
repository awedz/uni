import string
letters = 'NLMEEYRVHTBWNJSOGVI'
tar = ord('U')
moves = []
for letter in letters:
    temp = tar - ord(letter)
    moves.append(temp)
print(moves)
