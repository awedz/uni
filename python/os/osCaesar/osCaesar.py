def Encript(message, key):
    newMessage = []
    for letter in message:
        if ord(letter) >= 97 and ord(letter) <= 122:
            newChar = ord(letter) + key
            if newChar > 122:
                newMessage += chr(newChar - 26)
            else:
                newMessage += chr(newChar)
        elif ord(letter) >= 65 and ord(letter) <= 90:
            newChar = ord(letter) + key
            if newChar > 90:
                newMessage += chr(newChar - 26)
            else:
                newMessage += chr(newChar)
        else:
            newMessage += letter if letter != ' ' else ' '
    return "".join(newMessage)


def Decrypt(message, key):
    newMessage = []
    for letter in message:
        if ord(letter) >= 97 and ord(letter) <= 122:
            newChar = ord(letter) - key
            if newChar < 97:
                newMessage += chr(newChar + 26)
            else:
                newMessage += chr(newChar)
        elif ord(letter) >= 65 and ord(letter) <= 90:
            newChar = ord(letter) - key
            if newChar < 65:
                newMessage += chr(newChar + 26)
            else:
                newMessage += chr(newChar)
        else:
            newMessage += letter if letter != ' ' else ' '
    return "".join(newMessage)


testStr = "yt gj tw sty yt gj ymfy nx ymj vzjxynts"
#print(Encript(testStr, 1))
print(Decrypt(testStr, 5))
