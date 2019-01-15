from crypt import crypt

dinSalt = "$6$Tnd5Ce9O$"
dinHash = "nNhq84wKYQQwxKGqsBAsIMHIETB9MjOeO9ykuOmW9q6PO1v4qWEuCbfQKYQXK4D2uJjvgrkfnZfcMWqlQhOOm/"
star_range = 1
end_range = star_range * 100
fileDir = ''
fileName = ''
attempts = 0
def Crack():
    for i in range(star_range,end_range):
        with open("{}{}{}.txt".format(fileDir,fileName,i)) as file:
            for line in file:
                cur = line.strip()
                if crypt(cur , dinSalt) == dinSalt+dinHash:
                    print(cur)
                    return 1
        print("finish file {}".format(fileDir,fileName,i))