r,c,k = map(int,input().split())


numbers = [[0] * 3 for _ in range(3)]



for i in range(3):
    n1,n2,n3 = map(int,input().split())
    numbers[i][0] = n1
    numbers[i][1] = n2
    numbers[i][2] = n3



count = 0;

def turnTimeClock(nums,c,r):
    #c = len(nums)
    #r = len(nums[0])

    #print('c-',c)
    #print('r-',r)

    result = [[0] * c for _ in range(r)]
    #print(nums)
    for i in range(r):
        for j in range(c):
            result[i][j] = nums[j][i]
        #print(result)

    return result

def makeNumCountMap(nums):
    result = []

    for row in nums:
        result.append(countLine(row))
        
    
    
    
    return result

def countLine(line):
    #tmp = dict()
    #result = []
    #for n in line:
    #    if n not in tmp:
    #        if n != 0:
    #            tmp[n] = 1
    #    else:
    #        if n!= 0:
    #            tmp[n] += 1
    #print(tmp)
    #for i in tmp:
    #    result.append(i)
    #    result.append(tmp[i])
    
    
    #return result
    result = []

    count = 1
    
    for i in range(0,len(line)):
        #print('l-',line)
        if i==len(line)-1 and line[i] != line[i-1]:
            result.append(line[i])
            result.append(count)
            break;
        if line[i] == line[i+1]:
            count += 1
            if i == len(line)-2:
                result.append(line[i])
                result.append(count)
                break;
        else:
            result.append(line[i])
            result.append(count)
            count = 1
        
        
    #print(result)

    return result
    

ccc = 0
while numbers[r-1][c-1] != k:
    row = len(numbers[0])
    col = len(numbers)
    maxLine = 0
    if row>=col:
        count += 1
        numbers = makeNumCountMap(numbers)
        
    else:
        count +=1
        result = turnTimeClock(numbers,len(numbers),len(numbers[0]))
        print('result:',result)
        numbers = makeNumCountMap(result)
    
    #print(numbers)
    
    for i in numbers:
        maxLine = max(maxLine,len(i))

    for i in range(len(numbers)):
        while len(numbers[i]) != maxLine:
            numbers[i].append(0)
    print(numbers)
    ccc += 1
    if ccc>10:
        break;

    
#result = countLine([1,2,1])
#
#result2 = makeNumCountMap(numbers)
#print('re:',result2)
#print('re:',result)
print(count)
    
