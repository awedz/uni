import hashlib
import string
import itertools 
from crypt import crypt

dinSalt = "$6$Tnd5Ce9O$"
dinHash = "nNhq84wKYQQwxKGqsBAsIMHIETB9MjOeO9ykuOmW9q6PO1v4qWEuCbfQKYQXK4D2uJjvgrkfnZfcMWqlQhOOm/"

mypass = crypt("1a2s3d",dinSalt)
print(mypass)
print(mypass == dinSalt+dinHash)


def Crack():
    chars = string.ascii_lowercase + string.digits
    attempts = 0
    for password_length in range(6,7):
        for guess in itertools.product(chars,repeat = password_length):
            guess2 = list(guess)
            guess2.reverse()
            guess2 = ''.join(guess2)
            guess = ''.join(guess)
            attempts +=1
            if crypt(guess , dinSalt) == dinSalt+dinHash:
                print(guess)
                return 1
            if crypt(guess2, dinSalt) == dinSalt+dinHash:
                print(guess2)
                return 1
            if int(attempts) % 100000 == 0:
                print(str(attempts) + "guess1: " + guess + "guess2: "+guess2) 



#print(Crack())