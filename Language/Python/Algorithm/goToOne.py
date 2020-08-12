# 어떤 수를 다음 두 과정중 하나로 1이 될때까지 진행.
# 최소횟수를 구하기
# 1. N에서 1을 뺀다.
# 2. N을 K로 나눈다.

n,k = map(int, input().split())

count = 0

while n!=1:
    if n%k == 0 :
        n /=k
        count+=1
    else:
        n -= 1
        count+=1

print(count)
    
    
