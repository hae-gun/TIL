# sugar

N = (int)(input())
INF = 10000
dp = [0] * 5001

#print(dp)

for i in range(10):
    dp[i] = 10000

dp[3] = 1
dp[5] = 1


for i in range(6,N+1):
    dp[i] = min(dp[i-5],dp[i-3])+1
    


#print(dp)

#print(dp)
if dp[N] >= INF:
    print(-1)
else:
    print(dp[N])
