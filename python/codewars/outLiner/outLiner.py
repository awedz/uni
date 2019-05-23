

#[2, 4, 0, 100, 4, 11, 2602, 36]
#Should return: 11 (the only odd number)
#[160, 3, 1719, 19, 11, 13, -21]
#Should return: 160 (the only even number)

def find_outlier(integers):
        return [x for x in integers if x % 2 == 0][0] if sum([1 for x in integers if x % 2 == 0]) < sum(
        [1 for x in integers if x % 2 != 0]) else [x for x in integers if x % 2 != 0][0]


#odd = [1 for x in integers if x % 2 != 0]
#even = [1 for x in integers if x % 2 == 0]
#return odd[0] if sum(odd)< sum(even) else even[0]
print(find_outlier([1, 1, 8, 1, 1]))
