def solution(v):

    xSet = []
    ySet = []
    
    for i in v:
        xSet.append(i[0])
        ySet.append(i[1])


    print(xSet)
    print(ySet)

    x = dict()
    y = dict()
    

    for i in xSet:
        if i not in x:
            x[i] = 1
        else:
            x[i] += 1
    x = {v:k for k,v in x.items()}
        
    for i in ySet:
        if i not in y:
            y[i] = 1
        else:
            y[i] += 1   
    y = {v:k for k,v in y.items()}

    x = x[1]
    y = y[1]

    print(x,',',y)
    
v = [[1, 4], [3, 4], [3, 10]]
solution(v)
