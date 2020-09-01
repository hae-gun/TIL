a = list([0]*2 for _ in range(4))

#print(a)

for i in range(4):
    a[i] = list(map(int,input().split()))

#print(a)
preCount = 0
result =0

for i in range(4):
    curState = a[i][1] - a[i][0]

    curCount = preCount + curState
    result = max(result,curCount)
    preCount = curCount

print(result)

