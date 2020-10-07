# Weight
import itertools
N,K = map(int,input().split())

weights = list(map(int,input().split()))


#print(weights)
allList = list(itertools.permutations(weights,3))

offset = 500
count = len(allList)
for sets in allList:
    print(sets)
    for i in sets:
        offset -= K
        offset += i
        if offset < 500:
            count -= 1
            break
    

print(count)
