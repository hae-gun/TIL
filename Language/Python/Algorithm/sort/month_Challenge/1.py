def solution(numbers):
    
    a = numbers

    a.sort()


    numSet = [0] * (max(a)+1)
    result = []
    #print(a)

    for x in a:
        numSet[int(x)] += 1

    #print(numSet)


    for i in range(len(numSet)):
        first = 0
        #print('i')
        if numSet[i] != 0:
            for j in range(i+1,len(numSet)):
                #print('j')
                if numSet[j] != 0 and i+j not in result:
                    #print('j-if')
                    result.append(i+j)
        if numSet[i]>1 and 2*i not in result:
            result.append(2*i)
    
    result.sort()
    return result

