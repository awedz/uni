def tribonacci(signature, n):
    if n < 3:
        return [signature[0]]
    if n < 2:
        return []
    a = []
    for i in signature:
        a.append(i)
    [a.append(a[k-1]+a[k-2]+a[k-3])for k in range(3, n)]
    return a


t = tribonacci([1, 1, 1], 1)
print(t)
