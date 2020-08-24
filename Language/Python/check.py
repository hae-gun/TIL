

def solution(participant, completion):
    temp = dict()
    length = len(participant)
    
    
    
    
    for s in participant:
        if temp.has_key(s):
            temp[s] = temp[s]+1
        else:
            temp[s]=1
        
    
    
    
    print(temp)
    answer = ''
    
    return answer
