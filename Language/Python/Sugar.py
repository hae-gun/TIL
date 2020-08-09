N = list(map(int, input().split()))

N = N[0]
temp = N
sugarSet = [5,3]

result = 0

for i in sugarSet:
    lastResult = 0
    result += N//i
    N%=i
    lastResult = N%i


if(lastResult==0):
    print(result)
else:
    if(temp%sugarSet[1]==0):
        print(temp//sugarSet[1])
    else:
        print(-1)
