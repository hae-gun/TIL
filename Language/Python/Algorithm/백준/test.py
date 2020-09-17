def turnTimeClock(nums):

    c = len(nums)
    r = len(nums[0])

    print('c-',c)
    print('r-',r)

    result = [[0] * c for _ in range(r)]
    #print(nums)
    for i in range(r):
        for j in range(c):
            result[i][j] = nums[j][i]
        #print(result)

    return result
    


nums = [[1,2,3],[1,2,3]]

result = turnTimeClock(nums)

print(result)
