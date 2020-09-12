def solution(N, stages):
    answer=[]
    
    totalPeople = len(stages)

    stageMap = [0] * (N+1)
    
    
    for i in stages:
        stageMap[i-1] +=1
    
    answer.append(stageMap[0]/totalPeople)

    prev = totalPeople
    #print(stageMap)
    for idx in range(1,N+1):
        
        now = prev-stageMap[idx-1]
        #print(now)
        if now != 0:
            answer.append(stageMap[idx]/now)
        else:
            answer.append(1.0)
        prev = now
        #print(answer)
    
    del answer[N]    
    
    
    tmp = dict()

    for i in range(len(answer)):
        tmp[i+1] = answer[i]

    result = sorted(tmp.items(), key=lambda x: x[0])
    result = sorted(result, key=lambda x: x[1], reverse = True)
    #print(result)
    answer = []
    for i in range(len(result)):
        answer.append(result[i][0])
    
    return answer


N =4
stages = [4,4,4,4]

print(solution(N,stages))
