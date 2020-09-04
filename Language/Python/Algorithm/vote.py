number = int(input())


a=[[0]*3 for _ in range(3)]

point = []
for i in range(number):
    point=list(map(int,input().split()))
    for j in range(3):
        a[j][point[j]-1] +=1
        

#print(a)

total = 0
index=0
sumSet = [0,0,0]
for score in a:
    tmp = 1 * score[0] + 2 * score[1] + 3*score[2]
    total = max(total,tmp)
    sumSet[index]=tmp
    index +=1
    
#print(total)
#print(sumSet)
sameIndex = list()
for i in range(3):
    if sumSet[i] == total:
        sameIndex.append(i)
    else:
        otherIndex=i
maxIndex = 0

#print(sameIndex)
#print(otherIndex)
temp = a[otherIndex][0] + a[otherIndex][1]*10 + a[otherIndex][2]*100
#print(temp)
count = 0
for idx in sameIndex:
    Sum=0
    for j in range(3):
        Sum += a[idx][j]* (10**j)
    if temp < Sum:
        count+=1
        maxIndex=idx+1
        temp = Sum
    elif temp == Sum:
        count=0
        break

if count ==0:
    maxIndex=0
print(maxIndex,total)
    
