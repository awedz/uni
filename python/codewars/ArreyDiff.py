myStr = "os security course"


def array_diff(a, b):
    for x in b:
        t = x
        for y in a:
            if t == y:
                del a[a.index(t)]
    return a


d = [1, 2, 2]
f = []

print(d)
print(array_diff(d, f))
