from collections import deque
percent = deque(map(int,input().split(' ')))
#print(percent)
tmp = list()
for i in range (8,0,-1):
    tmp2 = list()
    for j in range(i-1):
        tmp2.append(percent.popleft()/100)
    tmp.append(tmp2)
    #print(tmp)
print(tmp)



