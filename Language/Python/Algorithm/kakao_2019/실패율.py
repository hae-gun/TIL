#, 2019 카카오 실패율



N = int(input())


stageMap = [0] * (N+2)

stages = list(map(int,input().split()))


for i in stages:
    stageMap[i] +=1


#print('map: ',stageMap)


# 해당 맵 까지 도달한 사람수
countThisMap = [0] * (N+1)
if stageMap[N+1] != 0:
    countThisMap[N] = stageMap[N+1]
else:
    countThisMap[N] = stageMap[N]

for i in range(N-1,-1,-1):
    countThisMap[i] = countThisMap[i+1] + stageMap[i]


#print('count: ',countThisMap)

# 실패율 구하기 : 1 - 현재맵에 존재하는 사람/현재맵 도달한사람
percent  = dict()

#percent[N] = 1 - countThisMap[N]/stageMap[N+1]

for i in range(N,-1,-1):
    if countThisMap[i] != 0:
        percent[i] = stageMap[i]/countThisMap[i]

#print(percent.items())
del percent[0]

result = sorted(percent.items(), key=lambda x: x[0])
result = sorted(result, key=lambda x: x[1], reverse = True)

answer = []
for i in range(len(result)):
    answer.append(result[i][0])

print(answer)
    
