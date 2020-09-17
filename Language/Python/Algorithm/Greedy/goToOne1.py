N = int(input())
count =0

dp = [0] * (N+1)

#print(dp)

dp[1] = 0

for i in range(2,N+1):
    dp[i] = dp[i-1] + 1
    #print(i,'-',dp[i])
    if i % 2 == 0:
        dp[i] = min(dp[i],dp[i//2]+1)
    #print(i,'-',dp[i])
    if i %3 == 0:
        dp[i] = min(dp[i],dp[i//3]+1)
    #print(i,'-',dp[i])


    
#print(dp)
print(dp[N])
