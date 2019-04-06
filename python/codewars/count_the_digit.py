def nb_dig(n, d):
    k = 0
    for x in range(n+1):
        powNum = str(int(x * x))
        k = k+powNum.count(str(d))
    return k