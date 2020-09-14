# 2
import itertools
import operator

def solution(orders, course):
    answer = []

    
    alphabet = dict()
    sets = []
    for i in orders:
        tmp = list(i)
        combiSet = []
        for j in range(2,len(tmp)):
            combiSet.append(list(itertools.combinations(tmp,j)))
        
        
       # print(combiSet)
        
        for j in combiSet:
            for k in j:
                tmp = ''.join(list(k))
                if tmp in alphabet:
                    alphabet[tmp] += 1
                else:
                    alphabet[tmp] = 1
            #sets.append(word)

        #print(sets)
    sdict= sorted(alphabet.items(), key=operator.itemgetter(1),reverse=True)


        
    print(sdict)
    

    return answer
    
    



orders = ["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]
course = [2,3,4]


solution(orders, course)
