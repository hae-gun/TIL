def countLine(line):

    result = []

    count = 1
    
    for i in range(0,len(line)):
        if i==len(line)-1 and line[i] != line[i-1]:
            result.append(line[i])
            result.append(count)
            break;
        if line[i] == line[i+1]:
            count += 1
        else:
            result.append(line[i])
            result.append(count)
            count = 1
            
        


    return result



line = [1,1,2,1,3]


print(countLine(line))
